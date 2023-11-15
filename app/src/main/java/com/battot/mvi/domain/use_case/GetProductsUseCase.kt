package com.battot.mvi.domain.use_case

import com.battot.mvi.common.Result
import com.battot.mvi.data.remote.dto.toOrder
import com.battot.mvi.domain.model.Order
import com.battot.mvi.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetProductsUseCase @Inject constructor(
    private val repository: MainRepository
) {
    operator fun invoke(): Flow<Result<List<Order>>> = flow {
        try {
            emit(Result.Loading)
            val orders: List<Order> = repository.getProducts().map { it.toOrder() }
            emit(Result.Success(orders))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }
    }.flowOn(Dispatchers.IO)
}