package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// TODO fill out CountryErrorScreen
@Composable
fun CountryErrorScreen(navController: NavController?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Error Will Robinson, Error!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
            Button(onClick = {
                navController?.navigate("main_screen")
            }) {
                Text("RETRY")
            }
        }
    }
}



// TODO fill out this preview.
@Preview
@Composable
fun CountryErrorScreenPreview() {
    CountryErrorScreen(navController = null )
}
