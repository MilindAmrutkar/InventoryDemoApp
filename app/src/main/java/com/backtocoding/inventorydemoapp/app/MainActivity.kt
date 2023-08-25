package com.backtocoding.inventorydemoapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.backtocoding.inventorydemoapp.presentation.ui.screens.ItemListScreen
import com.backtocoding.inventorydemoapp.presentation.ui.theme.InventoryDemoAppTheme
import com.backtocoding.inventorydemoapp.presentation.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: ItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryDemoAppTheme {
                MainContent(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainContent(viewModel: ItemViewModel) {
    ItemListScreen(viewModel = viewModel)
}