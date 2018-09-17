package com.example.shiranpeer.burritolocator.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Place : Serializable {
    var name: String? = null
    var vicinity: String? = null
    var description: String? = null
    @SerializedName("price_level")
    var priceLevel: Int = 0
    var geometry: Geometry? = null
}
