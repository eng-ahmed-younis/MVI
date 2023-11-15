package com.battot.mvi.data.remote.dto

import com.battot.mvi.domain.model.Order

data class OrderDtoItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)


fun OrderDtoItem.toOrder() : Order{
    return Order(
        id = this.id,
        title = this.title,
        image = this.image,
        price = this.price
    )
}