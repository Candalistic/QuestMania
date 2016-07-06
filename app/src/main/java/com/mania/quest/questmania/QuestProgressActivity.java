package com.mania.quest.questmania;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mania.quest.questmania.dummy.DummyContent;

import java.util.ArrayList;

public class QuestProgressActivity extends FragmentActivity implements OnMapReadyCallback,
        ItemFragment.OnListFragmentInteractionListener{

    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private ListView progressList;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_progress);

        fragmentManager = getSupportFragmentManager();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = SupportMapFragment.newInstance();
        mapFragment.getMapAsync(this);
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, mapFragment);
        transaction.commit();

        progressList = (ListView) findViewById(R.id.quest_progress_list);
        ArrayList<String> tempEntries = new ArrayList<>();
        tempEntries.add("Hello World");
        tempEntries.add("Hello World 1");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_textview, tempEntries);
        progressList.setAdapter(adapter);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item){

    }

    public void onMapViewClick(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, mapFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onListViewClick(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment listFragment = new ItemFragment();
        fragmentTransaction.replace(R.id.fragment_container, listFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
