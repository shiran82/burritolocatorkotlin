package com.example.shiranpeer.burritolocator.screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.shiranpeer.burritolocator.R;
import com.example.shiranpeer.burritolocator.databinding.MapLayoutBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.shiranpeer.burritolocator.databinding.ActivityPlacesOnMapBinding;

public class PlacesOnMapActivity extends FragmentActivity implements OnMapReadyCallback {
    private ActivityPlacesOnMapBinding binding;
    private GoogleMap mMap;
    private double lng;
    private double lat;
    private String name;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_on_map);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_places_on_map);



        MapLayoutBinding mapLayoutBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.map_layout, binding.frameLayout, true);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.gmap);
        mapFragment.getMapAsync(this);

        if(getIntent() != null){
            lng = getIntent().getDoubleExtra("lng", 0);
            lat = getIntent().getDoubleExtra("lat", 0);
            name = getIntent().getStringExtra("name");
            address = getIntent().getStringExtra("address");


            mapLayoutBinding.toolbar.setTitle(name);
            mapLayoutBinding.textViewAddress.setText(address);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(15);

        LatLng placeLoc = new LatLng(lat, lng);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(placeLoc)
                .title(name)
                .snippet(address)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin));

        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(placeLoc));


    }
}
