package com.backtocoding.inventorydemoapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemResponse(
    @Json(name = "status") val status: String,
    @Json(name = "items") val items: List<Item>
)