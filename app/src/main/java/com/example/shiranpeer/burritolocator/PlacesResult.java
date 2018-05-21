package com.example.shiranpeer.burritolocator;

import com.example.shiranpeer.burritolocator.model.Place;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PlacesResult implements Serializable {
    @SerializedName("results")
    private List<Place> places;
    @SerializedName("next_page_token")
    private String nextPageToken;

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
}
