package com.battot.mvi.presentation.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.battot.mvi.databinding.ActivityMainBinding
import com.battot.mvi.databinding.OrderItemBinding
import com.battot.mvi.domain.model.Order

class OrderAdapter constructor(
    val orderOnClick : OrderClickListener
): ListAdapter<Order,OrderAdapter.ViewHolder>(OrderDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  = ViewHolder.from(parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int)  = holder.bind(getItem(position),orderOnClick)


    class ViewHolder(
        private val binding: OrderItemBinding
    ) : RecyclerView.ViewHolder(binding.root){



        companion object{
            fun from(parent  : ViewGroup ) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = OrderItemBinding.inflate(layoutInflater)
                return ViewHolder(view)
            }
        }


        fun bind(order: Order,  clickListener: OrderClickListener){
            binding.order = order
            binding.orderClicked = clickListener
            binding.executePendingBindings()
        }

    }



    class OrderDiffUtils : DiffUtil.ItemCallback<Order>(){
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem.title == newItem.title
        }
    }

    class OrderClickListener(val clickListener: (id : Int) -> Unit ){
        fun onclick(order: Order){
            clickListener(order.id)
        }
    }


}