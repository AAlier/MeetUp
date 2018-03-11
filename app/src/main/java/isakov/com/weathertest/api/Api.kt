package isakov.com.weathertest.api

import android.text.style.ForegroundColorSpan

import isakov.com.weathertest.models.ForecastModel
import isakov.com.weathertest.models.GeneralModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

import isakov.com.weathertest.utils.Constants.GET_CITY_WEATHER
import isakov.com.weathertest.utils.Constants.GET_CITY_FORECAST

/**
 * Created by Isakov on 24-Sep-17.
 */

interface Api {

    @GET(GET_CITY_WEATHER)
    fun getCityWeather(@Query("id") id: Int, @Query("appid") appId: String, @Query("units") units: String): Call<GeneralModel>

    @GET(GET_CITY_WEATHER)
    fun getCityWeatherByName(@Query("q") name: String, @Query("appid") appId: String, @Query("units") units: String): Call<GeneralModel>

    @GET(GET_CITY_WEATHER)
    fun getCityWeatherByLocation(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("appid") appId: String, @Query("units") units: String): Call<GeneralModel>

    @GET(GET_CITY_FORECAST)
    fun getCityForecast(@Query("id") id: Int, @Query("cnt") cnt: Int, @Query("appid") appId: String, @Query("units") units: String): Call<ForecastModel>

}
