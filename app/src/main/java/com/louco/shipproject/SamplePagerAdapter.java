package com.louco.shipproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SamplePagerAdapter extends FragmentStatePagerAdapter{

    SamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return StockFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
