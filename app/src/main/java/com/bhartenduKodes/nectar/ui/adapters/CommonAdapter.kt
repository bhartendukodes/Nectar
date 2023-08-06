package com.bhartenduKodes.nectar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bhartenduKodes.nectar.databinding.OfferPriceBinding
import com.bhartenduKodes.nectar.data.model.Product

class CommonAdapter(val onItemClick:(Product) -> Unit):ListAdapter<Product, CommonAdapter.MyViewHolder>(CommonDiffUtils){

    inner class MyViewHolder(val binding:OfferPriceBinding):RecyclerView.ViewHolder(binding.root)

    object CommonDiffUtils:DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(OfferPriceBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            val symbol = "$ "
            ivGroceryImage.load(item.img)
            tvItemPrice.text = symbol.plus(item.amount)
            tvGroceryName.text = item.name
            tvItemQuantity.text = item.quantityDescription

            root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}
