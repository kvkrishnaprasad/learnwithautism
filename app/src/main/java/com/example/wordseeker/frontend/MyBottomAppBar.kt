package com.example.wordseeker.frontend

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wordseeker.frontend.pages.SequenceMaker

@Composable
fun MyBottomAppBar(navController: NavHostController) {
    Column {
        SequenceMaker()
        BottomAppBar(
            actions = {
                IconButton(onClick = { navController.navigate("categories") }) {
                    Icon(
                        Icons.Default.Home, contentDescription = "Home",
                        modifier = Modifier.size(48.dp)
                    )
                }
                IconButton(onClick = { navController.navigate("search") }) {
                    Icon(
                        Icons.Default.Search, contentDescription = "Search",
                        modifier = Modifier.size(48.dp)
                    )
                }
                IconButton(onClick = { navController.navigate("about") }) {
                    Icon(
                        Icons.Default.Settings, contentDescription = "about",
                        modifier = Modifier.size(48.dp)
                    )

                }
            },
        )
    }
}


