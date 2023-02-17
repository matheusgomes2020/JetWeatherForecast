package com.example.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetweatherforecast.screns.MainScreen
import com.example.jetweatherforecast.screns.WeatherSplashscreen
import com.example.jetweatherforecast.screns.main.MainViewModel
import com.example.jetweatherforecast.screns.search.SearchScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScrren.name ) {
        composable(WeatherScreens.SplashScrren.name){
            WeatherSplashscreen(navController = navController)
        }

        //www.google.com/cityname="seattle"
        val route = WeatherScreens.MainScrren.name
        composable("$route/{city}",
            arguments = listOf(
                navArgument(name = "city"){
                    type = NavType.StringType
                })){ navBack ->
            navBack.arguments?.getString("city").let { city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel,
                    city = city)
            }


        }
        /*

        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }

        composable(WeatherScreens.AboutScreen.name){
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.SettingsScreen.name){
            SettingsScreen(navController = navController)
        }

        composable(WeatherScreens.FavoriteScreen.name){
            FavoritesScreen(navController = navController)
        }

         */

    }
}