package com.example.shiranpeer.burritolocator.presenter

import com.example.shiranpeer.burritolocator.repository.MainActivityRepository
import com.example.shiranpeer.burritolocator.screen.mainActivity.MainActivityMvpView

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivityPresenter(private val repository: MainActivityRepository, private val mvpView: MainActivityMvpView) {
    private var subscription: Disposable? = null

    fun requestNearbyPlaces(types: String, locations: String, keyword: String, rankBy: String, apiKey: String) {
        if (!mvpView.isNetworkAvailable) {
            mvpView.showNetworkErrorMessage()
        } else {
            subscription = repository.getNearbyPlaces(types, locations, keyword, rankBy, apiKey)?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ placesResult ->
                        if (placesResult.status == OK) {
                            mvpView.hideProgressBar()
                            placesResult.nextPageToken!!.let { token ->
                                placesResult.places!!.let { places ->
                                    mvpView.showNearbyPlaces(places,
                                            token)
                                }
                            }
                        } else {
                            //TODO: error message should be according to status (based on requirements)
                            mvpView.showGPSErrorMessage()
                        }
                    }
                    ) {
                        mvpView.hideProgressBar()
                        mvpView.showGPSErrorMessage()
                    }
        }
    }

    fun requestNearbyPlacesAdditionalResults(pageToken: String, apiKey: String) {
        if (!mvpView.isNetworkAvailable) {
            mvpView.hideProgressBarLoader()
            mvpView.showNetworkErrorMessageForLoading()
        } else {
            subscription = repository.getNearbyPlacesAdditionalResults(pageToken, apiKey)
                    .repeat()
                    .takeUntil { placesResult ->
                        var retry = placesResult.requestRetry
                        retry++
                        placesResult.requestRetry = retry
                        placesResult.status == OK || retry == MAX_TRIES
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ placesResult ->
                        placesResult.places!!.let {
                            placesResult.nextPageToken!!.let { it1 ->
                                mvpView.showNearbyAdditionalPlaces(it,
                                        it1)
                            }
                        }
                    }
                    ) {
                        mvpView.showNetworkErrorMessageForLoading()
                        mvpView.hideProgressBarLoader()
                    }
        }
    }

    companion object {
        private const val OK = "OK"
        private const val MAX_TRIES = 4
    }
}
