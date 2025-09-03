package com.example.wordseeker.frontend

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.example.wordseeker.backend.store.PecsItemStore
import com.example.wordseeker.frontend.common.DragState
import com.example.wordseeker.frontend.pages.SequenceMaker
import kotlin.math.roundToInt

@Composable
fun MainApp() {
    val navController = rememberNavController()

    var drag by remember { mutableStateOf(DragState()) }

    var showSequenceBar by remember { mutableStateOf(true) }

    var isDragging by remember { mutableStateOf(false) }
    var dragOffset by remember { mutableStateOf(Offset.Zero) }
    var dropped by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize()) {
        Scaffold(
            bottomBar = { MyBottomAppBar(navController) },
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
//                        handleDrop(dropRegistry.hit(drag.posInRoot))
                        drag = DragState() // reset
                    },
                    onDragCancel = { drag = DragState() })
            }
        }

        if (drag.active && drag.item != null) {
            Box(Modifier.fillMaxSize()
                .zIndex(999f))
            {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .offset {IntOffset(drag.posInRoot.x.roundToInt()
                            , drag.posInRoot.y.roundToInt())}
                        .padding(2.dp)
                        .background(Color.LightGray, RoundedCornerShape(6.dp))
                ){
                    val pecs = PecsItemStore.findById(drag.item.orEmpty())
                    if (pecs != null) {
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