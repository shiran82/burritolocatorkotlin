package com.example.shiranpeer.burritolocator.screen;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.shiranpeer.burritolocator.Constant;
import com.example.shiranpeer.burritolocator.R;
import com.example.shiranpeer.burritolocator.databinding.MapLayoutBinding;
import com.example.shiranpeer.burritolocator.presenter.PlacesOnMapActivityPresenter;
import com.example.shiranpeer.burritolocator.util.NetworkUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.shiranpeer.burritolocator.databinding.ActivityPlacesOnMapBinding;

public class PlacesOnMapActivity extends FragmentActivity implements PlacesOnMapActivityMvpView, OnMapReadyCallback {
    private static final int MIN_ZOOM_PREFERENCE = 15;

    private ActivityPlacesOnMapBinding binding;
    private GoogleMap googleMap;
    private PlacesOnMapActivityPresenter presenter;

    private double lng;
    private double lat;
    private String name;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_on_map);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_places_on_map);

        presenter = new PlacesOnMapActivityPresenter(this);

        presenter.requestMaps();

    }

    @Override
    public void showMap() {
        MapLayoutBinding mapLayoutBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.map_layout, binding.frameLayout, true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);

        if(getIntent() != null){
            lng = getIntent().getDoubleExtra(Constant.EXTRA_LNG, 0);
            lat = getIntent().getDoubleExtra(Constant.EXTRA_LAT, 0);
            name = getIntent().getStringExtra(Constant.EXTRA_NAME);
            address = getIntent().getStringExtra(Constant.EXTRA_ADDRESS);

            mapLayoutBinding.toolbar.setTitle(name);
            mapLayoutBinding.textViewAddress.setText(address);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        this.googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.googleMap.setMinZoomPreference(MIN_ZOOM_PREFERENCE);

        LatLng placeLoc = new LatLng(lat, lng);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(placeLoc)
                .title(name)
                .snippet(address)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin));

        this.googleMap.addMarker(markerOptions);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(placeLoc));
    }

    @Override
    public void showNetworkErrorMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.network_error_message)
                .setPositiveButton(R.string.ok, (dialog, id) -> presenter.requestMaps())
                .setNegativeButton(R.string.cancel, (dialog, id) -> closeApp());

        builder.setCancelable(false);
        builder.create();

        builder.show();
    }

    @Override
    public boolean isNetworkAvailable() {
        return NetworkUtil.isNetworkAvailable(this);
    }

    private void closeApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        } else {
            finish();
        }
    }
}
