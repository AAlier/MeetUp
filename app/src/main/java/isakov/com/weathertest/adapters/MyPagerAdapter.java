package isakov.com.weathertest.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import isakov.com.weathertest.models.TabPagerItem;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<TabPagerItem> mTabs;

    public MyPagerAdapter(FragmentManager fragmentManager, List<TabPagerItem> tabs) {
        super(fragmentManager);
        this.mTabs = tabs;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return mTabs.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).getTitle();
    }
}
