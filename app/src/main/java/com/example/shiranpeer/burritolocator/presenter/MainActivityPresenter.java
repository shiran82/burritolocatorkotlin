package com.example.shiranpeer.burritolocator.presenter;

import android.util.Log;

import com.example.shiranpeer.burritolocator.screen.MainActivityMvpView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivityPresenter {
    private MainActivityRepository repository;
    private Disposable subscription;
    private MainActivityMvpView mvpView;

    public MainActivityPresenter(MainActivityRepository repository, MainActivityMvpView mvpView) {
        this.mvpView = mvpView;
        this.repository = repository;
    }

    public void requestNearbyPlaces(String types, String locations, String keyword, String rankBy, String apiKey) {
        mvpView.showProgressBar();
        subscription = repository.getNearbyPlaces(types, locations, keyword, rankBy, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(placesResult -> mvpView.showNearbyPlaces(placesResult.getPlaces(),
                        placesResult.getNextPageToken()),
                        e -> Log.e("Test", e.getMessage()));
    }

    public void requestNearbyPlacesAdditionalResults(String pageToken, String apiKey) {
        subscription = repository.getNearbyPlacesAdditionalResults(pageToken, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(placesResult -> {
                            mvpView.hideProgressBar();
                            mvpView.showNearbyAdditionalPlaces(placesResult.getPlaces(),
                                    placesResult.getNextPageToken());
                        },
                        e -> Log.e("Test", e.getMessage()));
    }

    public void onDetach() {
        if (subscription != null) {
            subscription.dispose();
        }
    }
}
