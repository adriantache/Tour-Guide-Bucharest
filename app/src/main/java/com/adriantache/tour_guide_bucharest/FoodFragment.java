package com.adriantache.tour_guide_bucharest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {
     private OnFragmentInteractionListener mListener;

    private ArrayList<Location> foodArray = new ArrayList<>();
    ListView listView;
    LocationArrayAdapter arrayAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateArray();
    }

    private void populateArray(){
        String type = getString(R.string.food);

        foodArray.add(new Location(type,R.drawable.tormen,getString(R.string.tormen),getString(R.string.address_tm),getString(R.string.phone_tm)));
        foodArray.add(new Location(type,R.drawable.atlantic,getString(R.string.atlantic),getString(R.string.address_atl),getString(R.string.phone_atl)));
        foodArray.add(new Location(type,R.drawable.shift,getString(R.string.shift),getString(R.string.address_shift),getString(R.string.phone_shift)));
        foodArray.add(new Location(type,R.drawable.don_vito,getString(R.string.don_vito),getString(R.string.address_dv),getString(R.string.phone_dv)));
        foodArray.add(new Location(type,R.drawable.toans,getString(R.string.toans),getString(R.string.address_tn),getString(R.string.phone_tn)));

        arrayAdapter = new LocationArrayAdapter(getContext(),foodArray);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
