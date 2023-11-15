package com.battot.mvi.domain.repository

import com.battot.mvi.data.remote.dto.OrderDto
import com.battot.mvi.data.remote.dto.OrderDtoItem
import com.battot.mvi.domain.model.Order

interface MainRepository {
    suspend fun getProducts() : OrderDto
    suspend fun getOrderById(id : Int) : OrderDtoItem
}