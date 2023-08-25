package com.backtocoding.inventorydemoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity
import com.backtocoding.inventorydemoapp.domain.usecases.FetchItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val fetchItemsUseCase: FetchItemsUseCase) :
    ViewModel() {
    private val _items = MutableStateFlow<List<ItemEntity>>(emptyList())

    val items: StateFlow<List<ItemEntity>> = _items

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            try {
                _loading.value = true
                _error.value = null

                val fetchedItems = fetchItemsUseCase.invoke()
                _items.value = fetchedItems
            } catch (exception: Exception) {
                _error.value = exception.message
            } finally {
                _loading.value = false
            }
        }
    }

}