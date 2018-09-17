package com.example.shiranpeer.burritolocator.screen.mainActivity

import com.example.shiranpeer.burritolocator.model.Place
import com.example.shiranpeer.burritolocator.screen.base.MvpView

interface MainActivityMvpView : MvpView {
    fun showNearbyPlaces(places: List<Place>, nextPageToken: String)

    fun showNearbyAdditionalPlaces(places: List<Place>, nextPageToken: String)

    fun hideProgressBar()

    fun showProgressBar()

    fun showGPSErrorMessage()

    fun showNetworkErrorMessageForLoading()

    fun hideProgressBarLoader()
}
