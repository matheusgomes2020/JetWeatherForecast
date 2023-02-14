package com.example.jetweatherforecast.repository

import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.WeatherObject
import com.example.jetweatherforecast.network.WeatherApi
import retrofit2.http.Query
import javax.inject.Inject

class WeatherRepository @Inject constructor( private val api: WeatherApi) {

    suspend fun getWeather( citQuery: String ): DataOrException<WeatherObject, Boolean, Exception> {

        val response = try {

            api.getWeather(query = citQuery)

        }catch (e: Exception){

            return DataOrException(e = e)

        }

        return DataOrException( data = response )

    }

}