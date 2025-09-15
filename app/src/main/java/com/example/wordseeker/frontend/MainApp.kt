package com.example.wordseeker.frontend

import GifImage
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.example.wordseeker.backend.store.PecsItemStore
import com.example.wordseeker.frontend.common.DragState
import kotlin.math.roundToInt

@Composable
fun MainApp() {
    val navController = rememberNavController()

    var drag by remember { mutableStateOf(DragState()) }


    var dropArea = Rect.Zero

    val droppedItems = remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        droppedItems.add("cat")
        droppedItems.add("car")
    }

    Box(Modifier.fillMaxSize()) {
        Scaffold(
            bottomBar = {
                MyBottomAppBar(
                    navController,
                    { rect -> dropArea = rect },
                    droppedItems
                )
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                NavBuild(navController,
                    onDragStart = { posInRoot, pecsId ->
                        drag = DragState(active = true, item = pecsId, posInRoot = posInRoot)
                    },
                    onDrag = { delta ->
                        drag = drag.copy(posInRoot = drag.posInRoot + delta)
                    },
                    onDragEnd = {
                        val ghostRect = Rect(
                            offset = drag.posInRoot,
                            size = Size(80f, 80f) // same as ghost size
                        )
                        if (dropArea.overlaps(ghostRect)) {
                            droppedItems.add(drag.item.orEmpty())
                        }
                        drag = DragState() // reset
                    },
                    onDragCancel = { drag = DragState() },
                    droppedItems)
            }
        }

        if (drag.active && drag.item != null) {
            Box(Modifier
                .fillMaxSize()
                .zIndex(999f))
            {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .offset {
                            IntOffset(
                                drag.posInRoot.x.roundToInt(), drag.posInRoot.y.roundToInt()
                            )
                        }
                        .padding(2.dp)
                        .background(Color.LightGray, RoundedCornerShape(6.dp))
                ){
                    val pecs = PecsItemStore.findById(drag.item.orEmpty())
                    if (pecs != null) {
                        if (pecs.gif) {
                            GifImage(pecs.image)
                        } else {
                            Image(
                                painter = painterResource(pecs.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .zIndex(0f)
                                    .fillMaxSize()
                                    .padding(5.dp)
                                    .height(100.dp)

                            )
                        }
                    }
                }

            }
        }

    }
}