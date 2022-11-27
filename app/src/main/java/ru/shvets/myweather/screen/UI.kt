package ru.shvets.myweather.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.shvets.myweather.data.Part
import ru.shvets.myweather.data.Weather
import ru.shvets.myweather.ui.theme.BlueLight

@Composable
fun ListItems(item: Part) {
    Card(
        modifier = Modifier
            .padding(top = 3.dp)
            .fillMaxWidth(),
        backgroundColor = BlueLight,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(top = 5.dp, start = 8.dp, bottom = 5.dp)
            ) {

                Text(text = item.part_name)

                Text(
                    text = item.condition,
                    color = Color.White
                )
            }

            Text(
                text = item.temp_avg.toString(),
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )

            AsyncImage(
                model = "https://yastatic.net/weather/i/icons/funky/dark/${item.icon}",
                contentDescription = "weather_icon_list",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(35.dp)
            )
        }
    }
}