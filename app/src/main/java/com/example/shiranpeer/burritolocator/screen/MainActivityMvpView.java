package com.example.shiranpeer.burritolocator.screen;

import com.example.shiranpeer.burritolocator.model.Place;
import com.example.shiranpeer.burritolocator.screen.base.MvpView;

import java.util.List;

public interface MainActivityMvpView extends MvpView {
     void showNearbyPlaces(List<Place> places, String nextPageToken);

     void showNearbyAdditionalPlaces(List<Place> places, String nextPageToken);

     void hideProgressBar();

     void showProgressBar();
}
