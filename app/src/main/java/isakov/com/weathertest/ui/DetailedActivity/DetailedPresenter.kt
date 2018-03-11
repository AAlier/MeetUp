package isakov.com.weathertest.ui.DetailedActivity

import isakov.com.weathertest.api.Api
import isakov.com.weathertest.models.ForecastModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailedPresenter(private val service: Api, val view: DetailedContract.View?) : DetailedContract.Presenter {

    override fun load(id: Int, appKey: String) {
        service.getCityForecast(id, 16, appKey, "metric").enqueue(
                object : Callback<ForecastModel> {
                    override fun onResponse(call: Call<ForecastModel>, response: Response<ForecastModel>) {
                        if (response.isSuccessful && response.body() != null) {
                            view?.success(response.body()!!)
                        }
                    }

                    override fun onFailure(call: Call<ForecastModel>, t: Throwable?) {
                        if (t != null) view?.error(t.message!!)
                    }
                }
        )
    }
}
