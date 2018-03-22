package com.adriantache.tour_guide_bucharest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DrinksFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DrinksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinksFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<Location> drinksArray = new ArrayList<>();
    ListView listView;
    LocationArrayAdapter arrayAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    public DrinksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinksFragment newInstance(String param1, String param2) {
        DrinksFragment fragment = new DrinksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        populateArray();
    }

    private void populateArray(){
        String type = "Drinks";

        drinksArray.add(new Location(type,R.drawable.shift,"Shift","Strada General Eremia Grigorescu 17","004 021 211 2272"));
        drinksArray.add(new Location(type,R.drawable.ota,"Ota","Strada Doctor Niculae D. Staicovici 26","004 0721 840 723"));
        drinksArray.add(new Location(type,R.drawable.gambrinus,"Gambrinus","Bulevardul Regina Elisabeta 38","004 0731 422 181"));
        drinksArray.add(new Location(type,R.drawable.manasia,"Manasia","Strada Stelea Spătarul 13","004 0736 787 885"));
        drinksArray.add(new Location(type,R.drawable.la_100_beri,"100 Beri","Strada Covaci 8","004 0372 963 543"));

        arrayAdapter = new LocationArrayAdapter(getContext(),drinksArray);

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

    public void call(View view){
        //do nothing
    }

}
