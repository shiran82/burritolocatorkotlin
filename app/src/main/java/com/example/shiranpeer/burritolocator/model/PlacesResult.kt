package com.example.shiranpeer.burritolocator.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PlacesResult : Serializable {
    @SerializedName("results")
    var places: List<Place>? = null
    @SerializedName("next_page_token")
    var nextPageToken: String? = null
    var status: String? = null
    var requestRetry: Int = 0
}
