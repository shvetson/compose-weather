package ru.shvets.myweather.repository

import retrofit2.Call
import ru.shvets.myweather.data.Weather

/** @author Oleg Shvets shvetson@gmail.com on 2022-09-25 */

interface WeatherRepository {

    fun getCurrentWeather(
        lat: Double,
        lon: Double,
        lang: String
    ): Call<Weather>
}