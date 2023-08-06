package com.bhartenduKodes.nectar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.databinding.ItemCartBinding
import java.math.RoundingMode
import java.text.DecimalFormat


class CartAdapter (private val onQuantityChanged: (Product) -> Unit):ListAdapter<Product , CartAdapter.MyViewModel>(CommonDiffUtil) {

    inner class MyViewModel(val binding:ItemCartBinding):RecyclerView.ViewHolder(binding.root)


    fun getTotalAmount(): Double {
        val cartItems = currentList
        return cartItems.sumOf { it.amount * it.quantity }
    }


    object CommonDiffUtil:DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val items = getItem(position)

        holder.binding.apply {
            ivProductImage.load(items.img)
            tvProductName.text = items.name
            tvWeight.text = items.quantityDescription
            tvValue.text = items.quantity.toString()

            val data: Double = items.quantity * items.amount
            val decimalFormat = DecimalFormat("#.##")
            val formattedData = decimalFormat.format(data)
            tvItemPrice.text = formattedData

            tvItemPrice.text = data.toString()

            ibAdd.setOnClickListener {
                onQuantityChanged(items.copy(quantity = items.quantity+1))
            }

            ibSub.setOnClickListener {
                if (items.quantity > 0) {
                    onQuantityChanged(items.copy(quantity = items.quantity-1))
                }
            }

        }
    }
}