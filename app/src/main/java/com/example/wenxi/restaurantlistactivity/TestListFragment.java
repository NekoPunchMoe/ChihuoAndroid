package com.example.wenxi.restaurantlistactivity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestListFragment extends Fragment {
    TestListFragment.OnItemSelectedListener myCallBack;

    public interface OnItemSelectedListener {
        public void onItemSelected(LatLng latLng);
    }
    public TestListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            myCallBack = (TestListFragment.OnItemSelectedListener) context;
        } catch (ClassCastException e) {
            //do something
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_list, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.restaurant_list_test);
        listView.setAdapter(new RestaurantAdapter(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Restaurant r = (Restaurant) listView.getItemAtPosition(i);
                myCallBack.onItemSelected(new LatLng(r.getLat(), r.getLng()));
            }
        });
        return view;
    }

}
