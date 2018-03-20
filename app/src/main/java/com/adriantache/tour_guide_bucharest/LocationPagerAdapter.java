package com.adriantache.tour_guide_bucharest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by TREE on 20/03/2018.
 */

public class LocationPagerAdapter extends FragmentPagerAdapter {

    public LocationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
