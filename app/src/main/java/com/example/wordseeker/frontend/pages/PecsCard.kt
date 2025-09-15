package com.example.wordseeker.frontend.pages

import GifImage
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.wordseeker.frontend.common.DragState
import kotlin.math.roundToInt

@Composable
fun PecsCard(cardName: String, image:Int, onClick: () -> Unit, zoom: Float,
             onDragStart: (posInRoot: Offset, id:String) -> Unit,
             onDrag: (delta: Offset) -> Unit,
             onDragEnd: () -> Unit,
             onDragCancel: () -> Unit,
             isGif: Boolean = false) {

    var coords by remember { mutableStateOf<LayoutCoordinates?>(null) }

    Box(
        modifier = Modifier
            .onGloballyPositioned { coords = it }
    ) {
        Row() {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.border(1.dp, color = Color.DarkGray)
                    .padding(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .pointerInput(Unit) {
                            detectDragGesturesAfterLongPress(
                                onDragStart = { pressOffsetInItem ->
                                    val rootTL = coords?.localToRoot(Offset.Zero) ?: Offset.Zero
                                    onDragStart(rootTL + pressOffsetInItem, cardName)
                                },
                                onDragEnd = {
                                    onDragEnd()
                                },
                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    onDrag(dragAmount)
                                },
                                onDragCancel = onDragCancel
                            )
                        }

                ) {
                    if (isGif) {
                        GifImage(image)
                    } else {
                        Image(
                            painter = painterResource(image),
                            contentDescription = null,
                            modifier = Modifier
                                .zIndex(0f)
                                .fillMaxSize()
                                .padding(5.dp)
                                .height(100.dp * zoom)
                                .clickable {
                                    onClick()
                                }

                        )
                    }
                }
                Text(text = cardName)
            }

        }
    }
}