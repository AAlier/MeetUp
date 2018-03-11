package isakov.com.weathertest.ui.BishkekFragment

import isakov.com.weathertest.models.GeneralModel

interface BishkekContract {
    interface View {
        fun success(model: GeneralModel)
        fun error(msg: String)
    }

    interface Presenter {
        fun load(appId: String)
    }
}
