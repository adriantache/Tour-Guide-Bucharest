package com.adriantache.tour_guide_bucharest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Fragment to hold the food locations
 */

public class FoodFragment extends Fragment {
    ListView listView;
    LocationArrayAdapter arrayAdapter;
    private ArrayList<Location> foodArray = new ArrayList<>();

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //todo fix not detecting click on call button problem :(
                if (view.getId() == R.id.call_button) {
                    String phoneNumber = foodArray.get(position).getPhone();

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    String address = "geo:0,0?q=" + foodArray.get(position).getName() + " " + foodArray.get(position).getAddress() + ", Bucuresti";

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(address));
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateArray();
    }

    private void populateArray() {
        String type = getString(R.string.food);

        foodArray.add(new Location(type, R.drawable.tormen, getString(R.string.tormen), getString(R.string.address_tm), getString(R.string.phone_tm)));
        foodArray.add(new Location(type, R.drawable.atlantic, getString(R.string.atlantic), getString(R.string.address_atl), getString(R.string.phone_atl)));
        foodArray.add(new Location(type, R.drawable.shift, getString(R.string.shift), getString(R.string.address_shift), getString(R.string.phone_shift)));
        foodArray.add(new Location(type, R.drawable.don_vito, getString(R.string.don_vito), getString(R.string.address_dv), getString(R.string.phone_dv)));
        foodArray.add(new Location(type, R.drawable.toans, getString(R.string.toans), getString(R.string.address_tn), getString(R.string.phone_tn)));

        arrayAdapter = new LocationArrayAdapter(getContext(), foodArray);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }
}
