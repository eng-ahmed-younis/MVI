package com.battot.mvi.data.remote

import com.battot.mvi.data.remote.dto.OrderDto
import com.battot.mvi.data.remote.dto.OrderDtoItem
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getProducts() : OrderDto

    @GET("products/{id}")
    suspend fun getOrder(@Path("id") id: Int) : OrderDtoItem

}