package com.example.wordseeker.frontend.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun About(navController: NavController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Developers - Venkat and Krishna. \n" +
                "Made to help people with speech impairments which is like using PECS but with sounds. \n" +
                "Also, helpful for my computer coding. \n" +
                "Enjoy the App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 50.dp))
        Button(onClick = {
            navController.popBackStack()
        }) { Text("Back") }
    }
}