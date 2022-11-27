package ru.shvets.myweather.repository

import retrofit2.Call
import ru.shvets.myweather.api.Common
import ru.shvets.myweather.data.Weather

/** @author Oleg Shvets shvetson@gmail.com on 2022-09-25 */

class WeatherRepositoryImpl : WeatherRepository {
    private val weatherApi = Common.weatherApiService

    override fun getCurrentWeather(
        lat: Double,
        lon: Double,
        lang: String
    ): Call<Weather> {
        return weatherApi.getCurrentWeather(lat, lon, lang)
    }
}