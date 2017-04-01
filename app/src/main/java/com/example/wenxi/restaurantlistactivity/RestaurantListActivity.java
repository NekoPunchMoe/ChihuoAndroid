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

public class RestaurantListActivity extends AppCompatActivity implements RestaurantListFragment.OnItemSelectListener, RestaurantGridFragment.OnItemSelectListener {
    RestaurantListFragment listFragment;
    RestaurantGridFragment gridFragment;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        Log.e("Life cycle test", "We are at onCreate()");
        relativeLayout = (RelativeLayout)findViewById(R.id.fragment_list_container);


        //add list view
        if (isTablet()) {
            listFragment = new RestaurantListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_list_container, listFragment).commit();
            relativeLayout.setVisibility(View.VISIBLE);
        } else {
            relativeLayout.setVisibility(View.GONE);
        }


        //add Gridview
        gridFragment = new RestaurantGridFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_grid_container, gridFragment).commit();
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * A dummy function to get fake restaurant names.
     *
     * @return an array of fake restaurant names.
     */
    private String[] getRestaurantNames() {
        String[] names= {
                "Restaurant1", "Restaurant2", "Restaurant3",
                "Restaurant4", "Restaurant5", "Restaurant6",
                "Restaurant7", "Restaurant8", "Restaurant9",
                "Restaurant10", "Restaurant11", "Restaurant12"};
        return names;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }
    @Override
    public void onItemSelected(int position){
        gridFragment.onItemSelected(position);
    }
    @Override
    public void onGridItemSelected(int position) {
        listFragment.onItemSelected(position);
    }
}