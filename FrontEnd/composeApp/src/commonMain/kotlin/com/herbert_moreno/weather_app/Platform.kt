package com.herbert_moreno.weather_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform