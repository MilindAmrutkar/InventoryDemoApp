package com.backtocoding.inventorydemoapp.domain.entities

data class ItemEntity(
    val itemName: String,
    val itemPrice: Int,
    val itemBarcode: String,
    val imageUrl: String
)