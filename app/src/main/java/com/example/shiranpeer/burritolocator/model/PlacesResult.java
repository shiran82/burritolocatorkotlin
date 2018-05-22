package com.example.shiranpeer.burritolocator.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PlacesResult implements Serializable {
    @SerializedName("results")
    private List<Place> places;
    @SerializedName("next_page_token")
    private String nextPageToken;
    private String status;
    private int requestRetry;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRequestRetry() {
        return requestRetry;
    }

    public void setRequestRetry(int requestRetry) {
        this.requestRetry = requestRetry;
    }
}
