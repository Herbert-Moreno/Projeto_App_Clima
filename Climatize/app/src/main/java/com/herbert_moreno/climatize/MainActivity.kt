package com.herbert_moreno.climatize

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.herbert_moreno.climatize.ui.component.WeatherIcon
import com.herbert_moreno.climatize.ui.component.WeatherView
import com.herbert_moreno.climatize.ui.theme.ClimatizeTheme
import com.herbert_moreno.climatize.ui.theme.PrimaryColor
import com.herbert_moreno.climatize.ui.theme.TextColor
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimatizeTheme {
                var apiData by remember { mutableStateOf(WeatherData(city = "city", temperature = "0", state = "sunny")) }
                val apiCorroutine = rememberCoroutineScope()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    var cityText by remember { mutableStateOf("City") }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(82.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(2.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                ) {
                                    TextField(
                                        value = cityText,
                                        onValueChange = { cityText = it },
                                        singleLine = true,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(12.dp))
                                            .width(320.dp)
                                            .background(color = TextColor, RectangleShape),
                                        textStyle = TextStyle(
                                            color = PrimaryColor,
                                            fontSize = 23.sp
                                        )
                                    )
                                    FloatingActionButton(
                                        onClick = {
                                            apiCorroutine.launch {
                                                if (cityText == "") {
                                                    apiData = WeatherData(city = "city", temperature = "0", state = "sunny")
                                                } else if (" " !in cityText) {
                                                    apiData = WeatherGetter().getWeather(cityText)
                                                } else {
                                                    apiData = WeatherData(city = "city", temperature = "0", state = "sunny")
                                                }
                                            }
                                        },
                                        contentColor = PrimaryColor,
                                        containerColor = TextColor
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.ic_search_category_default),
                                            contentDescription = "Search",
                                        )
                                    }
                                }
                            }
                            WeatherIcon(apiData.state)
                            WeatherView(
                                temperature = apiData.temperature,
                                city = apiData.city,
                                climateState = apiData.state
                            )
                        }
                    }
                }
            }
        }
    }
}