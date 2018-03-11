package isakov.com.weathertest.ui.DetailedActivity

import isakov.com.weathertest.models.ForecastModel

interface DetailedContract {

    interface View {
        fun success(model: ForecastModel)
        fun error(msg: String)
    }

    interface Presenter {
        fun load(id: Int, appKey: String)
    }
}
