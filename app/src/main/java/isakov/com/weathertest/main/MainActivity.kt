package isakov.com.weathertest.main

import android.os.Build
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import java.util.ArrayList

import isakov.com.weathertest.R
import isakov.com.weathertest.adapters.MyPagerAdapter
import isakov.com.weathertest.models.TabPagerItem
import isakov.com.weathertest.ui.BishkekFragment.BishkekFragment
import isakov.com.weathertest.ui.LondonFragment.LondonFragment
import isakov.com.weathertest.ui.SydneyFragment.SydneyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mTabs = ArrayList<TabPagerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTabs.add(TabPagerItem(getString(R.string.bishkek), BishkekFragment()))
        mTabs.add(TabPagerItem(getString(R.string.london), LondonFragment()))
        mTabs.add(TabPagerItem(getString(R.string.sydney), SydneyFragment()))
        initViewPager()
    }

    private fun initViewPager() {
        viewPager.offscreenPageLimit = mTabs.size
        viewPager.adapter = MyPagerAdapter(supportFragmentManager, mTabs)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tabs.elevation = 15f
        }

        tabs.setupWithViewPager(viewPager)
    }


}
