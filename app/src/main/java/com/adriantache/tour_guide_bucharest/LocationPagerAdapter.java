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
                return new FoodFragment();
            case 1:
                return new FunFragment();
            case 2:
                return new DrinksFragment();
            case 3:
                return new SightsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
