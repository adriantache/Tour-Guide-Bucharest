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
 * Fragment to hold the fun locations
 */

public class FunFragment extends Fragment {
    private LocationArrayAdapter arrayAdapter;
    private ArrayList<Location> funArray = new ArrayList<>();

    public FunFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //todo fix not detecting click on call button problem :(
                if (view.getId() == R.id.call_button) {
                    String phoneNumber = funArray.get(position).getPhone();

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    String address = "geo:0,0?q=" + funArray.get(position).getName() + ", " + funArray.get(position).getAddress() + ", Bucuresti";

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
        String type = getString(R.string.fun);

        funArray.add(new Location(type, R.drawable.expirat, getString(R.string.expirat), getString(R.string.address_exp), getString(R.string.phone_exp)));
        funArray.add(new Location(type, R.drawable.manasia, getString(R.string.manasia), getString(R.string.address_mn), getString(R.string.phone_mn)));
        funArray.add(new Location(type, R.drawable.imax, getString(R.string.imax), getString(R.string.address_imax), getString(R.string.phone_imax)));
        funArray.add(new Location(type, R.drawable.idm_club, getString(R.string.idm), getString(R.string.address_idm), getString(R.string.phone_idm)));
        funArray.add(new Location(type, R.drawable.mojo, getString(R.string.mojo), getString(R.string.address_mojo), getString(R.string.phone_mojo)));

        arrayAdapter = new LocationArrayAdapter(getContext(), funArray);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }
}
