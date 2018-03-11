package isakov.com.weathertest.ui.LondonFragment

import isakov.com.weathertest.models.GeneralModel

interface LondonContract {

    interface View {
        fun success(model: GeneralModel)
        fun error(msg: String)
    }

    interface Presenter {
        fun load(name: String, appId: String)
    }
}
