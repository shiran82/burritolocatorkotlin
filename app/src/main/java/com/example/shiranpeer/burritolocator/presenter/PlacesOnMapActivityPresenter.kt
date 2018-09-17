package com.example.shiranpeer.burritolocator.presenter

import com.example.shiranpeer.burritolocator.repository.MainActivityRepository
import com.example.shiranpeer.burritolocator.screen.PlacesOnMapActivityMvpView
import com.example.shiranpeer.burritolocator.screen.mainActivity.MainActivityMvpView

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class PlacesOnMapActivityPresenter(private val mvpView: PlacesOnMapActivityMvpView) {

    fun requestMaps() {
        if (!mvpView.isNetworkAvailable) {
            mvpView.showNetworkErrorMessage()
        } else {
            mvpView.showMap()
        }
    }
}
