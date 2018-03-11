package isakov.com.weathertest.ui.SydneyFragment

import isakov.com.weathertest.models.GeneralModel

interface SydneyContract {
    interface View {
        fun success(model: GeneralModel)
        fun error(msg: String)
    }

    interface Presenter {
        fun load(lat: Double, lon: Double, appId: String)
    }
}
