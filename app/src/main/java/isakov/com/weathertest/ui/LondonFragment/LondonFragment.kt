package isakov.com.weathertest.ui.LondonFragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import isakov.com.weathertest.R
import isakov.com.weathertest.WeatherApp
import isakov.com.weathertest.models.GeneralModel
import isakov.com.weathertest.ui.DetailedActivity.DetailedActivity
import isakov.com.weathertest.utils.Constants
import kotlinx.android.synthetic.main.fragment_weather.*
import java.text.DateFormat
import java.util.*

class LondonFragment : Fragment(), LondonContract.View {
    private lateinit var presenter: LondonPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val app = activity.application as WeatherApp
        presenter = LondonPresenter(app.service, this)
        presenter.load("London", getString(R.string.API_KEY))

        button.setOnClickListener { v ->
            val model = v.tag
            if (model is GeneralModel)
                startActivity(Intent(context, DetailedActivity::class.java)
                        .putExtra("model", model))
        }
    }

    override fun success(model: GeneralModel) {
        tvCity!!.text = model.name
        tvUpdate!!.text = String.format(getString(R.string.last_update), DateFormat.getDateTimeInstance().format(Date((model.dt * 1000).toLong())))
        tvCurTemp!!.text = String.format(getString(R.string.celsius), String.format(Locale.getDefault(), "%.2f", model.main?.temp))
        tvDetails!!.text = model.weatherList!![0].description
        Picasso.with(context)
                .load(String.format(Locale.getDefault(), Constants.WEATHER_ICON, model.weatherList!![0].icon))
                .into(imageView)
        button.tag = model
    }

    override fun error(msg: String) {
        Constants.showMessage(context, msg)
    }
}