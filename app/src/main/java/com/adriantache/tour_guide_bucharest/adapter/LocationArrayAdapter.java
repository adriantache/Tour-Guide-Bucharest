package com.adriantache.tour_guide_bucharest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adriantache.tour_guide_bucharest.Location;
import com.adriantache.tour_guide_bucharest.R;

import java.util.List;

/**
 * Custom array adapter to populate each list of locations
 */

public class LocationArrayAdapter extends ArrayAdapter<Location> {

    public LocationArrayAdapter(@NonNull Context context, @NonNull List<Location> objects) {
        super(context, 0, objects);
    }

    static class ViewHolder {
        ImageView imageView;
        TextView name;
        TextView address;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.location_image);
            holder.name = convertView.findViewById(R.id.name);
            holder.address = convertView.findViewById(R.id.address);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Location location = getItem(position);
        if (location != null) holder.imageView.setImageResource(location.getPhotoResID());
        if (location != null) holder.name.setText(location.getName());
        if (location != null) {
            String addressText = location.getAddress();
            if (addressText.length() > 30) addressText = addressText.substring(0, 27) + "...";
            holder.address.setText(addressText);
        }

        return convertView;
    }
}
