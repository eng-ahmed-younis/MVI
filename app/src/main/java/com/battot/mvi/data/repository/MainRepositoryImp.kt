package com.battot.mvi.data.repository

import com.battot.mvi.data.remote.ApiService
import com.battot.mvi.data.remote.dto.OrderDto
import com.battot.mvi.data.remote.dto.OrderDtoItem
import com.battot.mvi.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : MainRepository {

    override suspend fun getProducts(): OrderDto {
        return apiService.getProducts()
    }

    override suspend fun getOrderById(id: Int): OrderDtoItem {
        return apiService.getOrder(id)
    }

}