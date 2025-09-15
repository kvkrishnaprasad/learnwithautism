package com.example.wordseeker.frontend.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wordseeker.backend.store.PecsCategoryStore

@Composable
fun CategoryCard(name: String, image: Int, navController: NavController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .border(1.dp, Color(0x88888800))
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

    }
}




