package com.backtocoding.inventorydemoapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.backtocoding.inventorydemoapp.R
import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity

@Composable
fun ItemRow(item: ItemEntity, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(2.dp),

        ) {
        Column(
            modifier = modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = item.imageUrl,
                    error = painterResource(id = R.drawable.ic_error)
                ),
                contentDescription = "Item image for ${item.itemName}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Color.Gray, shape = CircleShape)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.itemName, color = Color.Black, fontWeight = FontWeight.Bold)
            Text(text = "$${item.itemPrice}", color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
        }
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