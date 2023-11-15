package com.battot.mvi.presentation

sealed class MainViewIntent  {
     object GetProducts  : MainViewIntent()
     data class GetOrderById(val id : Int) : MainViewIntent()
}