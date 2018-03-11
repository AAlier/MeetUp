package isakov.com.weathertest.ui.DetailedActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import isakov.com.weathertest.R
import isakov.com.weathertest.WeatherApp
import isakov.com.weathertest.adapters.ForecastAdapter
import isakov.com.weathertest.models.ForecastModel
import isakov.com.weathertest.models.GeneralModel
import isakov.com.weathertest.utils.Constants
import kotlinx.android.synthetic.main.activity_detailed.*
import kotlinx.android.synthetic.main.toolbar.*
import java.lang.reflect.Constructor

class DetailedActivity : AppCompatActivity(), DetailedContract.View {

    private lateinit var presenter: DetailedPresenter

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        init()
    }

    private fun init() {
        val model = intent.getParcelableExtra<GeneralModel>("model")

        val app = application as WeatherApp
        presenter = DetailedPresenter(app.service, this)
        presenter.load(model.id, getString(R.string.API_KEY))
    }

    override fun success(model: ForecastModel) {
        listView!!.adapter = ForecastAdapter(this, model.list)
    }

    override fun error(msg: String) {
        Constants.showMessage(this, msg)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}