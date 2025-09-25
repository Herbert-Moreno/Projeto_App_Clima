package com.herbert_moreno.climatize.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.herbert_moreno.climatize.ui.theme.SecondaryColor

@Composable
fun WeatherView(
    temperature: String = "0",
    city: String = "City",
    climateState: String = "Clouds"
    ) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(375.dp)
            .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp, bottomEnd = 0.dp, bottomStart = 0.dp))
            .background(
                color = SecondaryColor,
                shape = RectangleShape
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "$temperature°",
                fontSize = 132.sp
            )
            Text(
                text = "$city - $climateState",
                fontSize = 28.sp
            )
        }
    }
}