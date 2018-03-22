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
 * {@link SightsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SightsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SightsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView listView;
    LocationArrayAdapter arrayAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private ArrayList<Location> sightsArray = new ArrayList<>();

    public SightsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SightsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SightsFragment newInstance(String param1, String param2) {
        SightsFragment fragment = new SightsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        super.onViewCreated(view, savedInstanceState);
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
