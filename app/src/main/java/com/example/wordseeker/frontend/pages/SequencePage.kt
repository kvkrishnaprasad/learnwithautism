package com.example.wordseeker.frontend.pages

import android.media.MediaPlayer
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.wordseeker.backend.store.PecsItemStore

@Composable
fun SequencePage(navController: NavController, droppedItems: List<String>) {

    var zoom by remember { mutableStateOf(1f) }
    val columns = if (zoom > 1.5f) 1 else if (zoom > 1.3f) 2 else if (zoom > 1.1f) 3 else 4
    val context = LocalContext.current

    Column {
        Text("Sequence Area")
        Button(onClick = {
            navController.popBackStack()
        }) { Text("Back") }

        Box( ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(columns),
                modifier = Modifier
                    .border(width = 1.dp, color = Color(60, 60, 60))
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTransformGestures { _, _, zoomChange, _ ->
                            zoom *= zoomChange
                            // clamp zoom to avoid extremes
                            zoom = zoom.coerceIn(0.8f, 1.6f)
                        }
                    }
            ) {

                items(droppedItems.size) { index ->
                    val pecs = PecsItemStore.findById(droppedItems[index])
                    if (pecs != null) {
                        PecsCard(
                            pecs.name, pecs.image, {
                                if (pecs.sound != null) {
                                    val mediaPlayer = MediaPlayer.create(context, pecs.sound)
                                    mediaPlayer.start()
                                }
                            }, zoom,
                            onDragStart = { posInRoot, pecsId -> },
                            onDrag = { delta -> },
                            onDragEnd = {},
                            onDragCancel = {})
                    }
                }

            }

            // Delete Corner bin
            DeleteBin(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
//                    .onGloballyPositioned { coords ->
//                        val topLeft = coords.positionInRoot()
//                        val size = coords.size
//                        binBoundsInRoot = Rect(
//                            topLeft,
//                            androidx.compose.ui.geometry.Size(size.width.toFloat(), size.height.toFloat())
//                        )
//                    },
                ,
                true
            )

        }
    }
}


@Composable
private fun DeleteBin(
    modifier: Modifier,
    armed: Boolean
) {
//    val bg = if (armed) Color(0x7F0000) else Color(0xFF2b2b2b)
    val stroke = if (armed) Color.White else Color.White.copy(alpha = 0.8f)
    Box(
        modifier = modifier
            .size(72.dp)
            .zIndex(11f)
//            .background(bg, CircleShape)
            .border(1.dp, stroke, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        // You can replace with any bin icon
        Text("🗑️", color = Color.White)
    }
}




