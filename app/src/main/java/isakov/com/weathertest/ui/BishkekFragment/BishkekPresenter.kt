package isakov.com.weathertest.ui.BishkekFragment

import isakov.com.weathertest.api.Api
import isakov.com.weathertest.models.GeneralModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BishkekPresenter(val service: Api, val view: BishkekContract.View?) : BishkekContract.Presenter {

    override fun load(appId: String) {
        service.getCityWeather(1528334, appId, "metric")
                .enqueue(object : Callback<GeneralModel> {

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
