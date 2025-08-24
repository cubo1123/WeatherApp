package com.cubo1123.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.cubo1123.weatherapp.data.mappers.toWeatherInfo
import com.cubo1123.weatherapp.data.remote.WeatherApi
import com.cubo1123.weatherapp.domain.repository.WeatherRepository
import com.cubo1123.weatherapp.domain.util.Resource
import com.cubo1123.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        lat: Double,
        lng: Double
    ): Resource<WeatherInfo> {
        return try{
            Resource.Success(
                data = api.getWeatherData(lat = lat,long = lng).toWeatherInfo()
            )
        }catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error ocurred ")
        }
    }
}