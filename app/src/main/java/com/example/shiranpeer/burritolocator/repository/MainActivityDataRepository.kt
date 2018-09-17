package com.example.shiranpeer.burritolocator.repository

import com.example.shiranpeer.burritolocator.model.PlacesResult
import com.example.shiranpeer.burritolocator.service.PlacesService
import com.example.shiranpeer.burritolocator.service.APIClient

import io.reactivex.Observable

class MainActivityDataRepository : MainActivityRepository {
    override fun getNearbyPlaces(types: String, locations: String, keyword: String, rankBy: String, googlePlaceApiKey: String): Observable<PlacesResult>? {
        val apiService = APIClient.client!!.create(PlacesService::class.java)
        return apiService?.fetchNearbyPlaces(types, locations, keyword, rankBy, googlePlaceApiKey)
    }

    override fun getNearbyPlacesAdditionalResults(pageToken: String, googlePlaceApiKey: String): Observable<PlacesResult> {
        val apiService = APIClient.client!!.create(PlacesService::class.java)
        return apiService.fetchNearbyPlacesAdditionalResults(pageToken, googlePlaceApiKey)
    }
}
