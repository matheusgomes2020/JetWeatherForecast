package com.example.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetweatherforecast.screns.WeatherSplashscreen

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScrren.name ) {

        composable( WeatherScreens.SplashScrren.name ) {

            WeatherSplashscreen( navController = navController )

        }

    }

}