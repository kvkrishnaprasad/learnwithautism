package com.example.wordseeker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wordseeker.backend.AppInitializer
import com.example.wordseeker.frontend.NavBuild
import com.example.wordseeker.ui.theme.WordSeekerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppInitializer.initialize()
        setContent {
            WordSeekerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(230, 230, 230)
                )  {

                    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                        NavBuild()
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }
            }
        }

    }
}



