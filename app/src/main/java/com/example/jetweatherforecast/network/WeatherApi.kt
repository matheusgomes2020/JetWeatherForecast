package com.example.jetweatherforecast.network

import com.example.jetweatherforecast.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET(value = "data/2.5/forecast/daily")

    suspend fun getWeather(

        @Query( "q" ) query: String,
        @Query( "units" ) units: String = "metric",
        @Query( "appid" ) appid: String = Constants.API_KEY,

        ): Weather

}