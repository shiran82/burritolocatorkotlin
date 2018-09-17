package com.example.shiranpeer.burritolocator.service

import com.example.shiranpeer.burritolocator.model.PlacesResult

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesService {

    @GET("place/nearbysearch/json?")
    fun fetchNearbyPlaces(@Query(value = "types", encoded = true) type: String, @Query(value = "location", encoded = true)
    location: String, @Query(value = "keyword", encoded = true) keyword: String,
                          @Query(value = "rankby", encoded = true) rankBy: String,
                          @Query(value = "key", encoded = true) key: String): Observable<PlacesResult>

    @GET("place/nearbysearch/json?")
    fun fetchNearbyPlacesAdditionalResults(@Query(value = "pagetoken", encoded = true) pageToken: String,
                                           @Query(value = "key", encoded = true) key: String): Observable<PlacesResult>

}
  