package com.example.shiranpeer.burritolocator.repository;

import com.example.shiranpeer.burritolocator.PlacesResult;
import com.example.shiranpeer.burritolocator.presenter.MainActivityRepository;
import com.example.shiranpeer.burritolocator.service.PlacesService;
import com.example.shiranpeer.burritolocator.service.APIClient;

import io.reactivex.Observable;

public class MainActivityDataRepository implements MainActivityRepository {
    @Override
    public Observable<PlacesResult> getNearbyPlaces(String types, String locations, String keyword, String rankBy, String googlePlaceApiKey) {
        PlacesService apiService = APIClient.getClient().create(PlacesService.class);
        return apiService.fetchNearbyPlaces(types, locations, keyword, rankBy, googlePlaceApiKey);
    }

    @Override
    public Observable<PlacesResult> getNearbyPlacesAdditionalResults(String pageToken, String googlePlaceApiKey) {
        PlacesService apiService = APIClient.getClient().create(PlacesService.class);
        return apiService.fetchNearbyPlacesAdditionalResults(pageToken, googlePlaceApiKey);
    }
}
