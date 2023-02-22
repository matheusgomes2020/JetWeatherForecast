package com.example.jetweatherforecast.repository

import android.util.Log
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor( private val api: WeatherApi) {

    suspend fun getWeather(citQuery: String, units: String): DataOrException<Weather, Boolean, Exception> {

        val response = try {

            api.getWeather( query = citQuery, units = units )

        }catch (e: Exception){

            Log.d( "REX", "getWeather: $e" )
            return DataOrException(e = e)

        }

        Log.d( "INSIDE", "getWeather: $response" )

        return DataOrException( data = response )

    }

}