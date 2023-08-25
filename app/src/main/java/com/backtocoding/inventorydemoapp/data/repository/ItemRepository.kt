package com.backtocoding.inventorydemoapp.data.repository

import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity

interface ItemRepository {
    suspend fun fetchItems(): List<ItemEntity>
}