package com.backtocoding.inventorydemoapp.domain.repository

import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity

interface ItemRepository {
    suspend fun fetchItems(): Result<List<ItemEntity>>
}