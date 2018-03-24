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
 * Fragment to hold the drinks locations
 */

public class DrinksFragment extends Fragment {
    private LocationArrayAdapter arrayAdapter;
    private ArrayList<Location> drinksArray = new ArrayList<>();

    public DrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                view.findViewById(R.id.call_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phoneNumber = drinksArray.get(position).getPhone();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phoneNumber));
                        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });

                String address = "geo:0,0?q=" + drinksArray.get(position).getName() + ", " + drinksArray.get(position).getAddress() + ", Bucuresti";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(address));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
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
        String type = getString(R.string.drinks);

        drinksArray.add(new Location(type, R.drawable.shift, getString(R.string.shift), getString(R.string.address_shift), getString(R.string.phone_shift)));
        drinksArray.add(new Location(type, R.drawable.ota, getString(R.string.ota), getString(R.string.address_ota), getString(R.string.phone_ota)));
        drinksArray.add(new Location(type, R.drawable.gambrinus, getString(R.string.gambrinus), getString(R.string.address_gmb), getString(R.string.phone_gmb)));
        drinksArray.add(new Location(type, R.drawable.manasia, getString(R.string.manasia), getString(R.string.address_mn), getString(R.string.phone_mn)));
        drinksArray.add(new Location(type, R.drawable.la_100_beri, getString(R.string.la_100_beri), getString(R.string.address_100), getString(R.string.phone_100)));

        arrayAdapter = new LocationArrayAdapter(getContext(), drinksArray);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }
}
