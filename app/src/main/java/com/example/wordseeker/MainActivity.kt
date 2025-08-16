package com.example.wordseeker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wordseeker.backend.AppInitializer
import com.example.wordseeker.frontend.MainApp
import com.example.wordseeker.ui.theme.WordSeekerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppInitializer.initialize()
        setContent {
            WordSeekerTheme {
                MainApp()
            }
        }

    }
}




