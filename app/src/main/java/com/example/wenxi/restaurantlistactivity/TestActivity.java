package com.example.wenxi.restaurantlistactivity;

import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TestActivity extends AppCompatActivity implements TestListFragment.OnItemSelectedListener, OnMapReadyCallback {
    TestListFragment listFragment;
    MapFragment mapFragment;
    RelativeLayout relativeLayout;
    private LatLng toMark;
    private int number = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        relativeLayout = (RelativeLayout)findViewById(R.id.fragment_list_container_test);
        listFragment = new TestListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_list_container_test, listFragment).commit();
        relativeLayout.setVisibility(View.VISIBLE);
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.restaurant_map_test);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onItemSelected(LatLng latLng) {
        toMark = latLng;
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map) {
        if (toMark != null) {
            map.addMarker(new MarkerOptions().position(toMark).title("Marker"));
            map.moveCamera(CameraUpdateFactory.newLatLng(toMark));
            map.animateCamera(CameraUpdateFactory.zoomTo(number), 2000, null);
        }
    }
}
