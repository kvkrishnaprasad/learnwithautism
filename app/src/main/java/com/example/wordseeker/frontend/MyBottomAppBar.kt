package com.example.wordseeker.frontend

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wordseeker.frontend.pages.sequence.SequenceMaker

@Composable
fun MyBottomAppBar(navController: NavHostController,
                   updateArea: (Rect) -> Unit,
                   droppedItems: MutableList<String>,
) {
    var showSequenceBar by remember { mutableStateOf(true) }

    Column {
        if (showSequenceBar) {
            SequenceMaker(updateArea, droppedItems)
        }
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
                IconButton(onClick = {navController.navigate("seq")}) {
                    Icon(
                        Icons.Default.PlayArrow, contentDescription = "sequence",
                        modifier = Modifier.size(48.dp)
                    )
                }
                IconButton(onClick = {showSequenceBar = !showSequenceBar}) {
                    Icon(
                        Icons.Default.KeyboardArrowUp, contentDescription = "Toggle",
                        modifier = Modifier.size(48.dp)
                    )
                }
            },
        )
    }
}


