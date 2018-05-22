package com.example.shiranpeer.burritolocator.presenter;

import android.util.Log;

import com.example.shiranpeer.burritolocator.model.PlacesResult;
import com.example.shiranpeer.burritolocator.repository.MainActivityRepository;
import com.example.shiranpeer.burritolocator.screen.mainActivity.MainActivityMvpView;
import com.google.android.gms.common.api.Status;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivityPresenter {
    private MainActivityRepository repository;
    private Disposable subscription;
    private MainActivityMvpView mvpView;
    private final static String OK = "OK";

    public MainActivityPresenter(MainActivityRepository repository, MainActivityMvpView mvpView) {
        this.mvpView = mvpView;
        this.repository = repository;
    }

    public void requestNearbyPlaces(String types, String locations, String keyword, String rankBy, String apiKey) {
        if (!mvpView.isNetworkAvailable()) {
            mvpView.showNetworkErrorMessage();
        } else {
            subscription = repository.getNearbyPlaces(types, locations, keyword, rankBy, apiKey)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(placesResult -> {
                                if (placesResult.getStatus().equals(OK)) {
                                    mvpView.hideProgressBar();
                                    mvpView.showNearbyPlaces(placesResult.getPlaces(),
                                            placesResult.getNextPageToken());
                                } else {
                                    //TODO: error message should be according to status (based on requirements)
                                    mvpView.showGPSErrorMessage();
                                }
                            },
                            e -> {
                                mvpView.hideProgressBar();
                                mvpView.showGPSErrorMessage();
                            });
        }
    }

    public void requestNearbyPlacesAdditionalResults(String pageToken, String apiKey) {
        //delay added because of google map api - according to the documentation: "There is a short
        // delay between when a next_page_token is issued, and when it will become valid."
        Completable.timer(750, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(() -> MainActivityPresenter.this.requestNearbyPlacesAdditionalResultsAfterDelay(pageToken, apiKey));
    }

    public void requestNearbyPlacesAdditionalResultsAfterDelay(String pageToken, String apiKey) {
        if (!mvpView.isNetworkAvailable()) {
            mvpView.showNetworkErrorMessageForLoading();
        } else {
            subscription = repository.getNearbyPlacesAdditionalResults(pageToken, apiKey)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(placesResult -> {
                        mvpView.showNearbyAdditionalPlaces(placesResult.getPlaces(),
                                placesResult.getNextPageToken());
                    },
                            e -> {
                                mvpView.showNetworkErrorMessageForLoading();
                            });
        }
    }
}
