package com.example.wordseeker.frontend.common

import androidx.compose.ui.geometry.Offset

data class DragState (
    val active: Boolean = false,
    val item: String? = null,
    val posInRoot: Offset = Offset.Zero,   // current finger/ghost position in root coordinates


)

//    val active: Boolean = false,
//    val item: GalleryItem? = null,
//    val posInRoot: Offset = Offset.Zero,   // current finger/ghost position in root coordinates
//    val ghostSize: IntSize = IntSize.Zero  // for nice centering of the ghost
