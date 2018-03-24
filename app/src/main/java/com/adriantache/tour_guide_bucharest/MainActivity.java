package com.adriantache.tour_guide_bucharest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationPagerAdapter locationPagerAdapter = new LocationPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(locationPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        if (tabLayout.getTabAt(0) != null) {
            if (tabLayout.getTabAt(0) != null)
                tabLayout.getTabAt(0).setIcon(R.drawable.ic_restaurant_black_24dp);
            if (tabLayout.getTabAt(1) != null)
                tabLayout.getTabAt(1).setIcon(R.drawable.ic_local_play_black_24dp);
            if (tabLayout.getTabAt(2) != null)
                tabLayout.getTabAt(2).setIcon(R.drawable.ic_local_drink_black_24dp);
            if (tabLayout.getTabAt(3) != null)
                tabLayout.getTabAt(3).setIcon(R.drawable.ic_local_see_black_24dp);
        }
    }
}
