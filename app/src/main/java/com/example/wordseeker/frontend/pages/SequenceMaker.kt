package com.example.wordseeker.frontend.pages

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.wordseeker.backend.store.PecsItemStore

@Composable
fun SequenceMaker(updateArea: (Rect) -> Unit, droppedItems: List<String>) {

    var boxCoords by remember { mutableStateOf<LayoutCoordinates?>(null) }
    val scrollState = rememberScrollState()

    Row (
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color(0x5F5650a4))
            .horizontalScroll(scrollState) // makes Row scrollable,
            .onGloballyPositioned { coords ->
                boxCoords = coords
                val topLeft = coords.localToRoot(Offset.Zero)
                val size = coords.size
                updateArea(Rect(topLeft, Offset(topLeft.x + size.width, topLeft.y + size.height)))
            }
        ,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        droppedItems.forEach {
                pecsId ->
                    val pecs = PecsItemStore.findById(pecsId)
                    if (pecs != null) {
                        Image(
                            painter = painterResource(pecs.image),
                            contentDescription = null,
                            modifier = Modifier
                                .zIndex(0f)
                                .fillMaxSize()
                                .padding(5.dp)
                                .height(100.dp )
                        )
                    }
        }
        Box (Modifier.width(100.dp))
    }
}

@Composable
fun DropTargetSquare (
    index : Int,
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(2.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )
}

