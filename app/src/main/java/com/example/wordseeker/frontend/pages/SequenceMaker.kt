package com.example.wordseeker.frontend.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SequenceMaker() {

    val droppedItems = remember { mutableStateListOf<Pair<Int, String>>() }

    Row (
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        repeat(9) {
            idx ->
            DropTargetSquare(idx)

        }
    }
}

@Composable
fun DropTargetSquare (
    index : Int,
) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .padding(2.dp)
            .background(Color.LightGray, RoundedCornerShape(6.dp))
    )
}

