package com.cubo1123.weatherapp.domain.repository

import com.cubo1123.weatherapp.domain.util.Resource
import com.cubo1123.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat : Double , lng : Double) : Resource<WeatherInfo>
}