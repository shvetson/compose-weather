package ru.shvets.myweather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.shvets.myweather.data.Part
import ru.shvets.myweather.data.Weather
import ru.shvets.myweather.util.Constants.Companion.WEATHER_API_LANG
import ru.shvets.myweather.util.Constants.Companion.WEATHER_LOG
import ru.shvets.myweather.repository.WeatherRepositoryImpl
import ru.shvets.myweather.screen.MainCard
import ru.shvets.myweather.screen.TabLayout
import ru.shvets.myweather.ui.theme.MyWeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyWeatherTheme {

                Image(
                    painter = painterResource(id = R.drawable.weather_bg_3),
                    contentDescription = "weather bg",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds
                )

                Column {
                    MainCard()
                    getForecast()?.let { TabLayout(it) }
                }
            }
        }
    }
}

fun getForecast(): List<Part>? {
    val repo = WeatherRepositoryImpl()
    var list: List<Part>? = null

    val call = repo.getCurrentWeather(
        55.75396,
        37.620393,
        WEATHER_API_LANG
    )

    call.enqueue(object : Callback<Weather> {
        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
            Log.d(WEATHER_LOG, "OnResponse Success: ${response.message()}")
            list = response.body()?.forecast?.parts
            Log.d(WEATHER_LOG, list.toString())
        }

        override fun onFailure(call: Call<Weather>, t: Throwable) {
            Log.d(WEATHER_LOG, "OnFailure: ${t.message}")
        }
    })

    return list
}
