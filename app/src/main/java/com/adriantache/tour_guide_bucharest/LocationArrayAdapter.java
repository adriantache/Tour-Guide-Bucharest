package com.adriantache.tour_guide_bucharest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Custom array adapter to populate each list of locations
 */

public class LocationArrayAdapter extends ArrayAdapter<Location> {

    public LocationArrayAdapter(@NonNull Context context, int resource, @NonNull List<Location> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Location location = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location, parent, false);

        ImageView imageView = convertView.findViewById(R.id.location_image);
        imageView.setImageResource(location.getPhotoResID());

        TextView name = convertView.findViewById(R.id.name);
        name.setText(location.getName());

        TextView address = convertView.findViewById(R.id.address);
        String addressText = location.getAddress();
        if (addressText.length() > 30) addressText = addressText.substring(0, 27) + "...";
        address.setText(addressText);

        return convertView;
    }
}
