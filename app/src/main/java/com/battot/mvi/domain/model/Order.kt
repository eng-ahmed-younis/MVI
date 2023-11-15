package com.battot.mvi.domain.model

import com.battot.mvi.data.remote.dto.Rating

data class Order(
    val id: Int,
    val title: String,
    val image: String,
    val price: Double,
)