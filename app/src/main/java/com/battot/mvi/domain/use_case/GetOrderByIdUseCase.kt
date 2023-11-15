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

class GetOrderByIdUseCase @Inject constructor(
    private val repository: MainRepository
) {
    operator fun invoke(orderId : Int): Flow<Result<Order>> = flow {
        try {
            emit(Result.Loading)
            val order: Order = repository.getOrderById(orderId).toOrder()
            emit(Result.Success(order))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }
    }.flowOn(Dispatchers.IO)
}