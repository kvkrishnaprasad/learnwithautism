package com.example.wordseeker.frontend.pages.sequence

import GifImage
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SequenceCard(cardName: String, image: Int, sound: Int?, gif:Boolean?) {
    val context = LocalContext.current

    Box() {
        Column {
            if (true == gif) {
                GifImage(image)
            }
            else {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(100.dp)
                        .clickable {
                            if (sound != null) {
                                val mediaPlayer = MediaPlayer.create(context, sound)
                                mediaPlayer.start()
                            }
                        }

                )
            }
            Text(text = cardName)
        }
    }
}