package com.example.wordseeker.frontend.pages

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wordseeker.backend.store.PecsCategoryStore
import com.example.wordseeker.backend.store.PecsItemStore
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntSize
import com.example.wordseeker.frontend.common.DragState

@Composable
fun CategoryCard(name: String, image: Int, navController: NavController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .border(1.dp, Color.DarkGray)
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
fun PecsGrid(categoryId: String, navController: NavController, onDragStart: (posInRoot: Offset, id:String) -> Unit,
             onDrag: (delta: Offset) -> Unit,
             onDragEnd: () -> Unit,
             onDragCancel: () -> Unit) {
    var zoom by remember { mutableStateOf(1f) }
    val columns = if (zoom > 1.5f) 1 else if (zoom > 1.3f) 2 else if (zoom > 1.1f) 3 else 4
    val context = LocalContext.current
    Column {
        Text(categoryId)
        Button(onClick = {
            navController.popBackStack()
        }) { Text("Back") }
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.border(width = 1.dp, color = Color(40,40,40))
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, _, zoomChange, _ ->
                        zoom *= zoomChange
                        // clamp zoom to avoid extremes
                        zoom = zoom.coerceIn(0.8f, 1.6f)
                    }
                }
        ) {
            val a2 = PecsCategoryStore.getCategory(categoryId)?.items

            if (a2 != null) {
                items(a2.size) { index ->
                    val pecs = PecsItemStore.findById(a2[index])
                    if (pecs != null) {
                        PecsCard(pecs.name, pecs.image, {
                            if (pecs.sound != null) {
                                val mediaPlayer = MediaPlayer.create(context, pecs.sound)
                                mediaPlayer.start()
                            }
                        }, zoom, onDragStart, onDrag, onDragEnd, onDragCancel)
                    }
                }
            }
        }
    }
}




