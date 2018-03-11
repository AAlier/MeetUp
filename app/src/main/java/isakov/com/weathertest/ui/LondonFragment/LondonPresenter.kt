package isakov.com.weathertest.ui.LondonFragment

import isakov.com.weathertest.api.Api
import isakov.com.weathertest.models.GeneralModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LondonPresenter(private val service: Api,
                      private val view: LondonContract.View?) : LondonContract.Presenter {

    override fun load(name: String, appId: String) {
        service.getCityWeatherByName(name, appId, "metric").enqueue(
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
