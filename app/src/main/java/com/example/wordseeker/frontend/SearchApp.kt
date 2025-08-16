package com.example.wordseeker.frontend

import android.media.MediaPlayer
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wordseeker.backend.search.WordIndex
import com.example.wordseeker.backend.store.PecsItemStore

@Composable
fun SearchApp(navController: NavController) {
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        SearchBar(query) { newValue ->
            query = newValue
        }
        Spacer(modifier = Modifier.height(16.dp))
        SearchResults(query)
    }
}

@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = { onQueryChange(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Search") },
        singleLine = true
    )
}

@Composable
fun SearchResults(query: String) {
    // Filter based on query
    val filteredItems = remember(query) {
        WordIndex.searchByPrefix(query)
    }

    val context = LocalContext.current

    Column {
        if (query.isEmpty()) {
            Text("Start typing to search...")
        } else if (filteredItems.isEmpty()) {
            Text("No results found for \"$query\"")
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                Modifier.border(width = 3.dp, color = Color.Yellow)
            ) {
                items(filteredItems.size) { index ->
                    val word = filteredItems[index].word
                    val pecsItem = PecsItemStore.findById(word)
                    if (pecsItem != null) {
                        PecsCard(pecsItem.name, pecsItem.image) {
                            val mediaPlayer = MediaPlayer.create(context, pecsItem.sound)
                            mediaPlayer.start()
                        }
                    }else
                    {
                        Text("• ${filteredItems[index]}")
                    }
                }
            }
        }
    }
}

