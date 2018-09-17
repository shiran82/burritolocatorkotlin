package com.example.shiranpeer.burritolocator.repository

import com.example.shiranpeer.burritolocator.model.PlacesResult

import io.reactivex.Observable


interface MainActivityRepository {
    fun getNearbyPlaces(restaurant: String, s: String, burrito: String, distance: String, googlePlaceApiKey: String): Observable<PlacesResult>?

    fun getNearbyPlacesAdditionalResults(pageToken: String, googlePlaceApiKey: String): Observable<PlacesResult>
}
