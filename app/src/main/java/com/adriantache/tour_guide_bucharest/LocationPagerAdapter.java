package com.adriantache.tour_guide_bucharest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 *
 * Custom PagerAdapter to manage the Fragments
 *
 */

public class LocationPagerAdapter extends FragmentPagerAdapter {

    LocationPagerAdapter(FragmentManager fm) {
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
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Food";
            case 1:
                return "Fun";
            case 2:
                return "Drinks";
            case 3:
                return "Sights";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
