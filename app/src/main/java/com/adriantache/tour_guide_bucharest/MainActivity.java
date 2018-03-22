package com.adriantache.tour_guide_bucharest;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FoodFragment.OnFragmentInteractionListener, DrinksFragment.OnFragmentInteractionListener, FunFragment.OnFragmentInteractionListener, SightsFragment.OnFragmentInteractionListener {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        LocationPagerAdapter locationPagerAdapter = new LocationPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(locationPagerAdapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
     //do nothing
    }
}
