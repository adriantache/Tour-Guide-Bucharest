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
 * Fragment to hold the sights locations
 */

public class SightsFragment extends Fragment {
    ListView listView;
    LocationArrayAdapter arrayAdapter;
    private ArrayList<Location> sightsArray = new ArrayList<>();

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //todo fix not detecting click on call button problem :(
                if (view.getId() == R.id.call_button) {
                    String phoneNumber = sightsArray.get(position).getPhone();

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    String address = "geo:0,0?q=" + sightsArray.get(position).getName() + " " + sightsArray.get(position).getAddress() + ", Bucuresti";

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
        String type = getString(R.string.sights);

        sightsArray.add(new Location(type, R.drawable.casa_poporului, getString(R.string.casa_poporului), getString(R.string.address_cp), getString(R.string.phone_cp)));
        sightsArray.add(new Location(type, R.drawable.arcul_de_triumf, getString(R.string.arcul_de_triumf), getString(R.string.address_at), getString(R.string.phone_at)));
        sightsArray.add(new Location(type, R.drawable.ateneu, getString(R.string.ateneu), getString(R.string.address_atn), getString(R.string.phone_atn)));
        sightsArray.add(new Location(type, R.drawable.mnac, getString(R.string.mnac), getString(R.string.address_mnac), getString(R.string.phone_mnac)));
        sightsArray.add(new Location(type, R.drawable.muzeul_taranului, getString(R.string.muzeul_taranului), getString(R.string.address_mt), getString(R.string.phone_mt)));

        arrayAdapter = new LocationArrayAdapter(getContext(), sightsArray);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }
}
