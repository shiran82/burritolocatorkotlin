package com.example.shiranpeer.burritolocator.screen;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import com.example.shiranpeer.burritolocator.R;
import com.example.shiranpeer.burritolocator.adapter.PlacesRecyclerViewAdapter;
import com.example.shiranpeer.burritolocator.databinding.ActivityMainBinding;
import com.example.shiranpeer.burritolocator.presenter.MainActivityPresenter;
import com.example.shiranpeer.burritolocator.repository.MainActivityDataRepository;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.common.base.Strings;

import java.util.List;

public class MainActivity extends Activity implements MainActivityMvpView {
    private GeoDataClient geoDataClient;
    private PlaceDetectionClient placeDetectionClient;
    private ActivityMainBinding binding;
    private GoogleApiClient googleApiClient;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean locationPermissionGranted;
    private boolean isLocationAccessPermitted;
    private double lng;
    private double lat;
    private PlacesRecyclerViewAdapter recyclerViewAdapter;
    private MainActivityPresenter presenter;
    private FusedLocationProviderClient fusedLocationClient;
    public static final String GOOGLE_PLACE_API_KEY = "AIzaSyALCKLY7PD9Ke-xh2JVZi3IH0UCatbP_HI";

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        locationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationPermissionGranted = true;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Launcher);
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.toolbar.setTitle("Find my burrito");


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            return;
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        MainActivityMvpView mvpView = this;

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                lng = location.getLongitude();
                lat = location.getLatitude();

                presenter = new MainActivityPresenter(new MainActivityDataRepository(), mvpView);
                presenter.requestNearbyPlaces("restaurant, food", lat + "," + lng, "burrito", "distance", GOOGLE_PLACE_API_KEY);
            }
        });

//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        } else {
//            getCurrentPlaceItems();
//        }

    }

//
//    private void getCurrentPlaceData() {
//        @SuppressLint("MissingPermission") Task<PlaceLikelihoodBufferResponse> placeResult = placeDetectionClient.
//                getCurrentPlace(null);
//        placeResult.addOnCompleteListener(new OnCompleteListener<PlaceLikelihoodBufferResponse>() {
//            @Override
//            public void onComplete(@NonNull Task<PlaceLikelihoodBufferResponse> task) {
//                Log.d(TAG, "current location places info");
//                List<Place> placesList = new ArrayList<>();
//                PlaceLikelihoodBufferResponse likelyPlaces = task.getResult();
//                for (PlaceLikelihood placeLikelihood : likelyPlaces) {
////                    if (containsRestaurantOrFoodAndIsBurrito(placeLikelihood.getPlace().getPlaceTypes(),
////                            placeLikelihood.getPlace().getName())) {
////                        placesList.add(placeLikelihood.getPlace().freeze());
////                    }
//                }
//                likelyPlaces.release();
//
////                PlacesRecyclerViewAdapter recyclerViewAdapter = new
////                        PlacesRecyclerViewAdapter(placesList,
////                        MainActivity.this);
////                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
////                binding.recyclerView.setAdapter(recyclerViewAdapter);
//            }
//        });
//    }


//    private boolean containsRestaurantOrFoodAndIsBurrito(List<Integer> placeTypes, CharSequence name) {
//        for (Integer type : placeTypes) {
//            if ((type == Place.TYPE_RESTAURANT || type == Place.TYPE_FOOD) ){
//                return true;
//            }
//        }
//
//        return false;
//    }

    private void requestLocationAccessPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
    }

    @Override
    public void showNearbyPlaces(List<com.example.shiranpeer.burritolocator.model.Place> places, String nextPageToken) {
        recyclerViewAdapter = new PlacesRecyclerViewAdapter(places,
                MainActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (!Strings.isNullOrEmpty(nextPageToken)) {
                    presenter.requestNearbyPlacesAdditionalResults(nextPageToken, GOOGLE_PLACE_API_KEY);
                }
            }
        });

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(recyclerViewAdapter);
        binding.recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNearbyAdditionalPlaces(List<com.example.shiranpeer.burritolocator.model.Place> places, String nextPageToken) {
        recyclerViewAdapter.addItems(places);
//        PlacesRecyclerViewAdapter recyclerViewAdapter = new PlacesRecyclerViewAdapter(places,
//                MainActivity.this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        binding.recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
//            @Override
//            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//                if (!Strings.isNullOrEmpty(nextPageToken)) {
//                    presenter.requestNearbyPlacesAdditionalResults(nextPageToken);
//                }
//            }
//        });
//
//        binding.recyclerView.setLayoutManager(layoutManager);
//        binding.recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }
}
