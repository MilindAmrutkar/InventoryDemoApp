package com.backtocoding.inventorydemoapp.di

import com.backtocoding.inventorydemoapp.data.api.ApiService
import com.backtocoding.inventorydemoapp.data.mapper.ItemMapper
import com.backtocoding.inventorydemoapp.data.repository.ItemRepository
import com.backtocoding.inventorydemoapp.data.repository.ItemRepositoryImpl
import com.backtocoding.inventorydemoapp.domain.usecases.FetchItemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideItemMapper(): ItemMapper = ItemMapper()

    @Provides
    fun provideItemRepository(
        apiService: ApiService,
        itemMapper: ItemMapper
    ): ItemRepository =
        ItemRepositoryImpl(apiService, itemMapper)

    @Provides
    fun provideFetchItemsUseCase(repository: ItemRepository): FetchItemsUseCase =
        FetchItemsUseCase(repository)
}