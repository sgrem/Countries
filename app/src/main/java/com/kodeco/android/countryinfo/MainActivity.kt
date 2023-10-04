package com.kodeco.android.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodeco.android.countryinfo.data.RetrofitInstance
import com.kodeco.android.countryinfo.ui.components.CountryErrorScreen
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO build out the retrofit service and reference it here.
        //  Pass the service in to the CountryInfoScreen composable below.
        val countryService = RetrofitInstance.countryService


        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "main_screen") {
                composable("error_screen") {
                    CountryErrorScreen(navController)
                }
                composable("main_screen") {
                    MyApplicationTheme {
                        // TODO complete the composable content and provide
                        //  models for Country, CountryName, and CountryFlags.
                        CountryInfoScreen(navController, countryService)
                    }
                }
            }
        }
    }
}
