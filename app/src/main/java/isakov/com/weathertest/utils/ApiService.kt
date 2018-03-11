package isakov.com.weathertest.utils

import isakov.com.weathertest.api.Api
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Alier on 11.03.2018.
 */
object ApiService {
    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()

    private val interceptor = Interceptor { chain ->
        val ongoing = chain
                .request().newBuilder()
                .addHeader("Accept", "application/json;versions=1")
        chain.proceed(ongoing.build())
    }

    fun createService(): Api {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api::class.java)

    }
}