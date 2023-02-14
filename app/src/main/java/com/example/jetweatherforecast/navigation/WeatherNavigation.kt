package com.example.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetweatherforecast.screns.MainScreen
import com.example.jetweatherforecast.screns.WeatherSplashscreen
import com.example.jetweatherforecast.screns.main.MainViewModel

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScrren.name ) {

        composable( WeatherScreens.SplashScrren.name ) {

            WeatherSplashscreen( navController = navController )

        }

        composable( WeatherScreens.MainScrren.name ) {

            val mainViewModel = hiltViewModel<MainViewModel>()

            MainScreen( navController = navController, mainViewModel )

        }

    }

}