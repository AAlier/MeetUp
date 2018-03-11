package isakov.com.weathertest.ui.SydneyFragment

import isakov.com.weathertest.api.Api
import isakov.com.weathertest.models.GeneralModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SydneyPresenter(private val service: Api,
                      private val view: SydneyContract.View?) : SydneyContract.Presenter {

    override fun load(lat: Double, lon: Double, appId: String) {
        service.getCityWeatherByLocation(lat, lon, appId, "metric").enqueue(
                object : Callback<GeneralModel> {
                    override fun onResponse(call: Call<GeneralModel>, response: Response<GeneralModel>) {
                        if (response.isSuccessful && response.body() != null) {
                            view?.success(response.body()!!)
                        }
                    }

                    override fun onFailure(call: Call<GeneralModel>, t: Throwable?) {
                        if (t != null) view?.error(t.message!!)
                    }
                }
        )
    }
}
