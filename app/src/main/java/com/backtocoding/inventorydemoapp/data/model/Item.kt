package com.backtocoding.inventorydemoapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "itemName") val itemName: String,
    @Json(name = "itemPrice") val itemPrice: Int,
    @Json(name = "itemBarcode") val itemBarcode: String,
    @Json(name = "url") val url: String
)