package com.backtocoding.inventorydemoapp.data.repository

import com.backtocoding.inventorydemoapp.data.api.ApiService
import com.backtocoding.inventorydemoapp.data.mapper.ItemMapper
import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity

class ItemRepositoryImpl(
    private val apiService: ApiService,
    private val itemMapper: ItemMapper
) : ItemRepository {
    override suspend fun fetchItems(): List<ItemEntity> {
        val response = apiService.fetchItems()
        return response.items.map {
            itemMapper.mapToEntity(it)
        }
    }
}