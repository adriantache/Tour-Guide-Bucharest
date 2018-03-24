package com.adriantache.tour_guide_bucharest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.adriantache.tour_guide_bucharest.DrinksFragment;
import com.adriantache.tour_guide_bucharest.FoodFragment;
import com.adriantache.tour_guide_bucharest.FunFragment;
import com.adriantache.tour_guide_bucharest.SightsFragment;

/**
 *
 * Custom PagerAdapter to manage the Fragments
 *
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
