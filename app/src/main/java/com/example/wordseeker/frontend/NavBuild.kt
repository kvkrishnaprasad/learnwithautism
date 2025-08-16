package com.example.wordseeker.frontend

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wordseeker.frontend.pages.About
import com.example.wordseeker.frontend.pages.CategoriesGrid
import com.example.wordseeker.frontend.pages.PecsGrid
import com.example.wordseeker.frontend.pages.SearchApp

@Composable
fun NavBuild(navController: NavHostController) {
//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") { CategoriesGrid(navController) }
        composable("second/{categoryId}",
            arguments = listOf(navArgument("categoryId") {type = NavType.StringType})
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "aa"
            PecsGrid(categoryId, navController)
        }
        composable("about") { About(navController) }
        composable("search") { SearchApp(navController)  }
    }
}


