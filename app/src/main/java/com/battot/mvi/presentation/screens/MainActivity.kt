package com.battot.mvi.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.battot.mvi.databinding.ActivityMainBinding
import com.battot.mvi.domain.model.Order
import com.battot.mvi.presentation.MainStateView
import com.battot.mvi.presentation.MainViewIntent
import com.battot.mvi.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: OrderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        createAdapter()
        renderState()


    }

    private fun setupViews(){
        binding.button.setOnClickListener {
            getProductsFromNetwork()
        }
    }


    private fun createAdapter(){
        adapter = OrderAdapter(OrderAdapter.OrderClickListener {
        lifecycleScope.launch { viewModel.intentChannel.send(MainViewIntent.GetOrderById(it)) }
        })
    }

    //send
    private fun getProductsFromNetwork(){
        lifecycleScope.launch {
            viewModel.intentChannel.send(MainViewIntent.GetProducts)
        }
    }


    //render
    private fun renderState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        is MainStateView.Idle -> {
                            Toast.makeText(this@MainActivity, "idle", Toast.LENGTH_LONG).show()
                        }
                        is MainStateView.Loading ->{
                            Log.i("displayList_tag","loading")
                        }

                        is MainStateView.Success -> {
                            displayList(it.orders)
                        }
                        is MainStateView.Error ->{
                            Log.i("displayList_tag",it.message.toString())
                        }
                        is MainStateView.OrderById->{
                            displayOrderById(it.order)
                        }

                    }
                }
            }
        }
    }


    private fun displayList(order: List<Order>){
        adapter.submitList(order)
        binding.orderList.adapter = adapter
    }

    private fun displayOrderById(order: Order){
        Log.i("currentOrder","title is ${order.title}")
    }


}