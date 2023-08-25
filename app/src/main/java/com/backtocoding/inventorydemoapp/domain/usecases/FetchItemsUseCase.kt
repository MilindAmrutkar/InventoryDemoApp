package com.backtocoding.inventorydemoapp.domain.usecases

import com.backtocoding.inventorydemoapp.data.repository.ItemRepository
import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity


class FetchItemsUseCase(
    private val repository: ItemRepository
) : UseCase<List<ItemEntity>, Unit> {
    override suspend fun invoke(params: Unit): List<ItemEntity> {
        return repository.fetchItems()
    }
}