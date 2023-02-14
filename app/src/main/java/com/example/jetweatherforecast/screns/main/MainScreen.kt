package com.example.jetweatherforecast.screns

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.screns.main.MainViewModel

@Composable
fun MainScreen(navController: NavController,
               mainViewModel: MainViewModel = hiltViewModel()) {
    
    ShowData(mainViewModel)
    
}

@Composable
fun ShowData( mainViewModel: MainViewModel ) {

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException( loading = true ) ) {

        value = mainViewModel.getWeatherData( city = "Campinas" )

    }.value

    if ( weatherData.loading == true ) {

        CircularProgressIndicator()

    }else if( weatherData.data != null ){

        Text(text = "Main Screen ${ weatherData.data!!.toString() }")

    }

}