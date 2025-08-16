package com.example.wordseeker.frontend

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wordseeker.backend.store.PecsCategoryStore
import com.example.wordseeker.backend.store.PecsItemStore
import com.example.wordseeker.backend.store.PecsStore

@Composable
fun CategoryCard(name: String, image: Int, navController: NavController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .border(1.dp, Color.Red)
                .clickable {
                    navController.navigate("second/" + name)
                }
        )
        Text(text = name, textAlign = TextAlign.Center )
    }
}

@Composable
fun CategoriesGrid(navController: NavController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text("")
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(10.dp)
        ) {
            val categories = PecsCategoryStore.fetchCategories().toTypedArray()
            items(categories.size) { index ->
                CategoryCard(categories[index].name,
                    categories[index].image,
                    navController)
            }
        }
        Button(onClick = {
            navController.navigate("about")
        }, Modifier.padding(vertical = 50.dp)){ Text("About") }
        Button(onClick = {
            navController.navigate("search")
        }, Modifier.padding(vertical = 50.dp)) { Text("Search") }
    }
}

@Composable
fun PecsGrid(categoryId: String, navController: NavController) {
    val context = LocalContext.current
    Column {
        Text(categoryId)
        Button(onClick = {
            navController.popBackStack()
        }) { Text("Back") }
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            Modifier.border(width = 3.dp, color = Color.Yellow)
        ) {
            val a2 = PecsCategoryStore.getCategory(categoryId)?.items

            if (a2 != null) {
                items(a2.size) { index ->
                    val pecs = PecsItemStore.findById(a2[index])
                    if (pecs != null) {
                        PecsCard(pecs.name, pecs.image) {
                            val mediaPlayer = MediaPlayer.create(context, pecs.sound)
                            mediaPlayer.start()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PecsCard(cardName: String, image:Int, onClick: () -> Unit) {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp)
                .width(100.dp)
                .height(100.dp)
                .border(2.dp, color = Color.Green)
                .clickable {
                    Log.d("asdfd", "asfaff")
                    onClick()
                }
        )
        Text(text = cardName)
    }
}
