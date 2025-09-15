package com.example.wordseeker.frontend.pages.sequence


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.wordseeker.backend.store.PecsItemStore
import com.example.wordseeker.frontend.pages.PecsCard
import kotlin.math.roundToInt

@Composable
fun SequencePage(navController: NavController, droppedItems: MutableList<String>) {

    var zoom by remember { mutableStateOf(1f) }
    val columns = if (zoom > 1.5f) 1 else if (zoom > 1.3f) 2 else if (zoom > 1.1f) 3 else 4
    val context = LocalContext.current

    var dragActive by remember { mutableStateOf(true) }
    var dragItem by remember { mutableStateOf("") }
    var dragPosInRoot by remember { mutableStateOf(Offset.Zero) }

    var targetRect by remember { mutableStateOf<Rect?>(null) }

    var coords by remember { mutableStateOf<LayoutCoordinates?>(null) }

    Column {



        Text("Sequence Area")
        Button(onClick = {
            navController.popBackStack()
        }) { Text("Back") }

        Box(
            modifier = Modifier
                .onGloballyPositioned { coords = it }
        ) {
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
                        Box(modifier = Modifier
                            .pointerInput(Unit) {
                                detectDragGesturesAfterLongPress(
                                    onDragStart = {pressOffsetInItem ->
                                        dragActive = true
                                        dragItem = pecs.name
                                        val rootTL = coords?.localToRoot(Offset.Zero) ?: Offset.Zero
                                        dragPosInRoot = rootTL + pressOffsetInItem},
                                    onDragEnd = {
                                        dragActive = false
                                        val ghostRect = Rect(
                                            offset = dragPosInRoot,
                                            size = Size(80f, 80f) // same as ghost size
                                        )
                                        if (targetRect?.overlaps(ghostRect) == true)
                                            droppedItems.remove(dragItem)
                                    },
                                    onDrag = {change, dragAmount ->
                                        change.consume()
                                        dragPosInRoot += dragAmount
                                    },
                                    onDragCancel = {
                                        dragActive = false
                                    }
                                )
                            }
                        ) {
                            SequenceCard(
                                pecs.name, pecs.image, pecs.sound, pecs.gif
                            )
                        }
                    }
                }
            }


            if (dragActive) {
                val pecs = PecsItemStore.findById(dragItem)
                if (pecs != null) {
                    Box(
                        modifier = Modifier
                            .zIndex(99f)
                            .offset {

                                IntOffset(0,0
//                                    dragPosInRoot.x.roundToInt(), dragPosInRoot.y.roundToInt()
                                )
                            }
                            .background(Color.LightGray, RoundedCornerShape(6.dp))
                            .size(100.dp)
                    ) {
                        Image(
                            painter = painterResource(pecs.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        )
                    }
                }
            }


            // Delete Corner bin
            DeleteBin(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .onPlaced { coords ->
                        //val pos = coords.positionInRoot()
                        val size = coords.size
                        targetRect = Rect(
                            offset = coords.positionInRoot(),
                            size = Size(80f, 80f)
                            //size = Size(size.width.toFloat(), size.height.toFloat())
                        )
                    }
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



@Composable
fun SequenceLocalCard() {

}



