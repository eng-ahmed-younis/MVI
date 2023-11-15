package com.battot.mvi.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.battot.mvi.common.Result
import com.battot.mvi.domain.use_case.GetOrderByIdUseCase
import com.battot.mvi.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getOrderByIdUseCase: GetOrderByIdUseCase
) : ViewModel() {

    val intentChannel = Channel<MainViewIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainStateView>(MainStateView.Idle)
    val state: StateFlow<MainStateView>
        get() = _state


    init {
        handleIntents()
    }

    // act as process
    private fun handleIntents() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect {
                Log.i("displayList_tag","${it}")

                when (it) {
                   is MainViewIntent.GetProducts -> getProducts()
                    is MainViewIntent.GetOrderById -> getOrderById(it.id)
                }
            }
        }
    }



    // act as produce
    private fun getProducts(){
        viewModelScope.launch {
            getProductsUseCase().collect{
              _state.value = when(it){
                  is Result.Loading ->{ MainStateView.Loading }
                  is Result.Success-> { MainStateView.Success(orders = it.data) }
                  is Result.Error->{ MainStateView.Error(message = it.exception) }
              }
            }
        }
    }



    private fun getOrderById(id : Int){
        viewModelScope.launch {
            getOrderByIdUseCase(orderId = id).collect{
                _state.value = when(it){
                    is Result.Loading ->{ MainStateView.Loading }
                    is Result.Success-> { MainStateView.OrderById(order = it.data)}
                    is Result.Error->{ MainStateView.Error(message = it.exception) }
                }
            }
        }
    }


}