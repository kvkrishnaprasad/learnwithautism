package com.example.wordseeker.frontend

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wordseeker.frontend.pages.About
import com.example.wordseeker.frontend.pages.CategoriesGrid
import com.example.wordseeker.frontend.pages.PecsGrid
import com.example.wordseeker.frontend.pages.SearchApp
import com.example.wordseeker.frontend.pages.SequencePage

@Composable
fun NavBuild(navController: NavHostController, onDragStart: (posInRoot: Offset, id: String) -> Unit,
             onDrag: (delta: Offset) -> Unit,
             onDragEnd: () -> Unit,
             onDragCancel: () -> Unit,
             droppedItems: List<String>) {
    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") { CategoriesGrid(navController) }
        composable("second/{categoryId}",
            arguments = listOf(navArgument("categoryId") {type = NavType.StringType})
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "aa"
            PecsGrid(categoryId, navController, onDragStart, onDrag, onDragEnd, onDragCancel)
        }
        composable("about") { About(navController) }
        composable("search") { SearchApp(navController)  }
        composable("seq") { SequencePage(navController, droppedItems) }
    }
}


