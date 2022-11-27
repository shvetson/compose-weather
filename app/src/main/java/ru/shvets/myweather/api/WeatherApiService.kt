package ru.shvets.myweather.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.shvets.myweather.data.Weather
import ru.shvets.myweather.util.Constants.Companion.WEATHER_API_KEY

interface WeatherApiService {

    @Headers("X-Yandex-API-Key: $WEATHER_API_KEY")
    @GET("v2/informers")
    fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("lang") lang: String
    ): Call<Weather>
}