package com.backtocoding.inventorydemoapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity

@Composable
fun ItemRow(item: ItemEntity, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(8.dp)
            .background(Color.LightGray)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = item.imageUrl),
            contentDescription = "Item image for ${item.itemName}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.itemName, fontWeight = FontWeight.Bold)
        Text(text = "${item.itemPrice}")
    }
}

@Preview
@Composable
fun PreviewItemRow() {
    val item = ItemEntity(
        itemName = "CLh8FsEbezR3Ol",
        itemPrice = 262,
        itemBarcode = "615684372",
        imageUrl = "https://db.ezobooks.in/kappa/image/get/9370740235/f3643e12-1854-4131-9781-f27e39300f7e6336/b2e4c1eb-18c9-43ec-8802-94ef7c764598"
    )
    ItemRow(item = item)
}