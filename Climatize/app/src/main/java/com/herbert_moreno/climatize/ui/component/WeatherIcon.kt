package com.herbert_moreno.climatize.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import com.herbert_moreno.climatize.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun WeatherIcon(
    weatherState: String = "clear sky"
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        contentAlignment = Alignment.Center
    ) {
        when (weatherState) {
            "clear" -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imageSize by infiniteScale.animateFloat(
                    initialValue = 220f,
                    targetValue = 235f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.sunny,
                    content = "clear sky",
                    modifier = Modifier.size(imageSize.dp)
                )
            }
            "clouds" -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imagePos by infiniteScale.animateFloat(
                    initialValue = -8f,
                    targetValue = 8f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.cloudy,
                    content = "few clouds",
                    modifier = Modifier.offset(x=imagePos.dp, y=0.dp)
                )
            }
            "drizzle" -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imagePos by infiniteScale.animateFloat(
                    initialValue = -8f,
                    targetValue = 8f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.rainy,
                    content = "broken clouds",
                    modifier = Modifier.offset(x=0.dp, y=imagePos.dp)
                )
            }
            "rain" -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imagePos by infiniteScale.animateFloat(
                    initialValue = -8f,
                    targetValue = 8f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.heavyrainy,
                    content = "shower rain",
                    modifier = Modifier.offset(x=0.dp, y=imagePos.dp)
                )
            }
            "thunderstorm" -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imageSize by infiniteScale.animateFloat(
                    initialValue = 220f,
                    targetValue = 235f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.thunderstormy,
                    content = "thunderstorm",
                    modifier = Modifier.size(imageSize.dp)
                )
            }
            "snow" -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imageRot by infiniteScale.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Restart
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.snowy,
                    content = "snow",
                    modifier = Modifier.rotate(imageRot)
                )
            }
            else -> {
                val infiniteScale = rememberInfiniteTransition(label = "infinite")
                val imageSize by infiniteScale.animateFloat(
                    initialValue = 220f,
                    targetValue = 235f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "sizeChange"
                )
                DisplayImage(
                    id = R.drawable.sunny,
                    content = " ",
                    modifier = Modifier.size(imageSize.dp)
                )
            }
        }
    }
}

@Composable
fun DisplayImage(
    id: Int,
    content: String = "",
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(
            id = id
        ),
        contentDescription = content,
        modifier = modifier
            .size(
                width = 220.dp,
                height = 220.dp
            )
    )
}