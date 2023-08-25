package com.backtocoding.inventorydemoapp.data.mapper

import com.backtocoding.inventorydemoapp.data.model.Item
import com.backtocoding.inventorydemoapp.domain.entities.ItemEntity

class ItemMapper {
    fun mapToEntity(item: Item): ItemEntity {
        return ItemEntity(
            itemName = item.itemName,
            itemPrice = item.itemPrice,
            itemBarcode = item.itemBarcode,
            imageUrl = item.url
        )
    }

    fun mapFromEntity(entity: ItemEntity): Item {
        return Item(
            itemName = entity.itemName,
            itemPrice = entity.itemPrice,
            itemBarcode = entity.itemBarcode,
            url = entity.imageUrl
        )
    }
}