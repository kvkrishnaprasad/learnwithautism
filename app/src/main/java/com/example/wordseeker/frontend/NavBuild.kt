package com.example.wordseeker.frontend

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavBuild() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") { CategoriesGrid(navController) }
        composable("second/{categoryId}",
            arguments = listOf(navArgument("categoryId") {type = NavType.StringType})
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "aa"
            PecsGrid(categoryId, navController)
        }
        composable("about") {About(navController)}
        composable("search") { SearchApp(navController)  }
    }
}


