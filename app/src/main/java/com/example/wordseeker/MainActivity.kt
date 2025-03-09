package com.example.wordseeker

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wordseeker.store.PecsStore
import com.example.wordseeker.ui.theme.WordSeekerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PecsStore.populate()
        setContent {
            WordSeekerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(200, 200, 200)
                ) {
                    NavBuild()
                }
            }
        }

    }
}

@Composable
fun NavBuild() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") { CategoriesGrid(navController) }
        composable("second/{categoryId}",
            arguments = listOf(navArgument("categoryId") {type = NavType.StringType})
            ) { backStackEntry ->
                val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "aa"
                PecsGrid(categoryId)
        }
    }
}

@Composable
fun CategoryCard(name: String, image: Int, navController: NavController) {
    Column {
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
        Text(text = name)
    }
}

@Composable
fun CategoriesGrid(navController: NavController) {
    Column {
        Text("")
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(10.dp)
        ) {
            val categories = PecsStore.fetchCategories().toTypedArray()
            items(categories.size) { index ->
                CategoryCard(categories[index].name,
                    categories[index].image,
                    navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WordSeekerTheme {
        NavBuild()
    }
}


@Composable
fun PecsGrid(categoryId: String) {
    val context = LocalContext.current
    Column {
        Text(categoryId)
        LazyVerticalGrid(
            columns = GridCells.Fixed(4)
        ) {
            val a2 = PecsStore.fetchPecs(categoryId).toTypedArray()
            items(a2.size) { index ->
                PecsCard(a2[index].name, a2[index].image) {
                    val mediaPlayer = MediaPlayer.create(context, a2[index].sound)
                    mediaPlayer.start()
                }
            }
        }
    }
}

@Composable
fun PecsCard(cardName: String, image:Int, onClick: () -> Unit) {
    Column {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp)
                .width(100.dp)
                .height(100.dp)
                .clickable {
                    Log.d("asdfd", "asfaff")
                    onClick()
                }
        )
        Text(text = cardName)
    }
}



@Preview(showBackground = true)
@Composable
fun PecsPreview() {
    WordSeekerTheme {
        PecsGrid("fruits")
    }
}



