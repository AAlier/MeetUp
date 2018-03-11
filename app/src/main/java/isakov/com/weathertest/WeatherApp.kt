package isakov.com.weathertest

import android.app.Application
import isakov.com.weathertest.api.Api
import isakov.com.weathertest.utils.ApiService

class WeatherApp : Application() {

    lateinit var service: Api

    override fun onCreate() {
        super.onCreate()
        service = ApiService.createService()
    }
}
