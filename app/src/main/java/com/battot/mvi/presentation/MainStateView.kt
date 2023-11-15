package com.battot.mvi.presentation

import com.battot.mvi.domain.model.Order
import java.util.Objects

sealed class MainStateView {
    object Idle : MainStateView()
    object Loading : MainStateView()
    data class Success(val orders  : List<Order>) : MainStateView()
    data class Error(val message : Throwable) : MainStateView()
    data class OrderById(val order: Order) : MainStateView()

}
