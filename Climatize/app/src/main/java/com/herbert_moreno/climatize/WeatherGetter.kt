package com.herbert_moreno.climatize

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class WeatherData(val city: String, val temperature: String, val state: String)

class WeatherGetter {
    val client = HttpClient(CIO)
    suspend fun getWeather(city: String): WeatherData {
        val apiCall: HttpResponse = client.get("https://projeto-app-clima.onrender.com/$city")
        if (apiCall.status == HttpStatusCode.OK) {
            val jsonString: String = apiCall.body()
            val response: WeatherData = Json.decodeFromString(jsonString)

            return response
        }
        else {
            return WeatherData(city = "city", temperature = "0", state = "sunny")
        }
    }
}