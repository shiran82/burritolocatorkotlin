package com.example.shiranpeer.burritolocator.screen.mainActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.shiranpeer.burritolocator.R;
import com.example.shiranpeer.burritolocator.adapter.PlacesRecyclerViewAdapter;
import com.example.shiranpeer.burritolocator.databinding.ActivityMainBinding;
import com.example.shiranpeer.burritolocator.presenter.MainActivityPresenter;
import com.example.shiranpeer.burritolocator.receiver.ConnectivityReceiver;
import com.example.shiranpeer.burritolocator.repository.MainActivityDataRepository;
import com.example.shiranpeer.burritolocator.screen.EndlessRecyclerViewScrollListener;
import com.example.shiranpeer.burritolocator.util.NetworkUtil;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.common.base.Strings;

import java.util.List;

public class MainActivity extends Activity implements MainActivityMvpView, ConnectivityReceiver.ConnectivityReceiverListener {
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private static final String TYPES = "restaurant, food";
    private static final String BURRITO = "burrito";
    private static final String DISTANCE = "distance";

    private PlacesRecyclerViewAdapter recyclerViewAdapter;
    private MainActivityPresenter presenter;
    private FusedLocationProviderClient fusedLocationClient;
    private ActivityMainBinding binding;

    private double lng;
    private double lat;
    private String pageToken;
    private boolean refreshRequired;
    private ConnectivityReceiver connectivityReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.toolbar.toolbar.setTitle(R.string.app_name);

        refreshRequired = false;

        binding.buttonFindMyBurrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialize();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocationAndFindNearbyPlaces();
                } else {
                    closeApp();
                }
            }
        }
    }

    @Override
    public void showNearbyPlaces(List<com.example.shiranpeer.burritolocator.model.Place> places, String nextPageToken) {
        this.pageToken = nextPageToken;
        recyclerViewAdapter = new PlacesRecyclerViewAdapter(places);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (!Strings.isNullOrEmpty(pageToken)) {
                    presenter.requestNearbyPlacesAdditionalResults(pageToken, getString(R.string.google_maps_key));
                }
            }
        });

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(recyclerViewAdapter);
        binding.recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNearbyAdditionalPlaces(List<com.example.shiranpeer.burritolocator.model.Place> places, String nextPageToken) {
        this.pageToken = nextPageToken;
        recyclerViewAdapter.addItems(places);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showGPSErrorMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.gps_error_message)
                .setPositiveButton(R.string.ok, (dialog, id) -> fetchLocationAndFindNearbyPlaces())
                .setNegativeButton(R.string.cancel, (dialog, id) -> closeApp());

        builder.setCancelable(false);
        builder.create();

        builder.show();
    }

    @Override
    public void showNetworkErrorMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.network_error_message)
                .setPositiveButton(R.string.ok, (dialog, id) -> fetchLocationAndFindNearbyPlaces())
                .setNegativeButton(R.string.cancel, (dialog, id) -> closeApp());

        builder.setCancelable(false);
        builder.create();

        builder.show();
    }

    @Override
    public void showNetworkErrorMessageForLoading() {
        refreshRequired = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.network_error_message_for_loading)
                .setPositiveButton(R.string.ok, (dialog, id) -> dialog.dismiss());

        builder.setCancelable(false);
        builder.create();

        builder.show();
    }

    @Override
    public boolean isNetworkAvailable() {
        return NetworkUtil.isNetworkAvailable(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (!Strings.isNullOrEmpty(pageToken) && isConnected && refreshRequired) {
            Toast.makeText(this, getString(R.string.online_again), Toast.LENGTH_LONG).show();
            presenter.requestNearbyPlacesAdditionalResults(pageToken, getString(R.string.google_maps_key));
            pageToken = "";
            refreshRequired = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        connectivityReceiver = new ConnectivityReceiver();
        registerReceiver(connectivityReceiver, intentFilter);

        ConnectivityReceiver.connectivityReceiverListener = this;
    }

    @SuppressLint("MissingPermission")
    private void fetchLocationAndFindNearbyPlaces() {

        showProgressBar();
        MainActivityMvpView mvpView = this;

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                lng = location.getLongitude();
                lat = location.getLatitude();

                presenter = new MainActivityPresenter(new MainActivityDataRepository(), mvpView);
                presenter.requestNearbyPlaces(TYPES, lat + "," + lng, BURRITO, DISTANCE,
                        getString(R.string.google_maps_key));
            } else {
                hideProgressBar();
                showGPSErrorMessage();
            }
        });
    }

    private void initialize() {
        binding.buttonFindMyBurrito.setVisibility(View.GONE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        } else {
            fetchLocationAndFindNearbyPlaces();
        }
    }

    private void closeApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        } else {
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (connectivityReceiver != null) {
            unregisterReceiver(connectivityReceiver);
        }
    }
}
