package com.example.shiranpeer.burritolocator.service;

import com.example.shiranpeer.burritolocator.model.PlacesResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlacesService {

    @GET("place/nearbysearch/json?")
    Observable<PlacesResult> fetchNearbyPlaces(@Query(value = "types", encoded = true) String type, @Query(value = "location",
            encoded = true) String location, @Query(value = "keyword", encoded = true) String keyword,
                                               @Query(value = "rankby", encoded = true) String rankBy,
                                               @Query(value = "key", encoded = true) String key);

    @GET("place/nearbysearch/json?")
    Observable<PlacesResult> fetchNearbyPlacesAdditionalResults(@Query(value = "pagetoken", encoded = true) String pageToken,
                                                                @Query(value = "key", encoded = true) String key);

}
  