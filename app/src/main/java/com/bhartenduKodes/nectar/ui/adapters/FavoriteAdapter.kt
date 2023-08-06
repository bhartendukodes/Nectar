package com.bhartenduKodes.nectar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.databinding.ItemFavoruriteBinding

class FavoriteAdapter(): ListAdapter<Product, FavoriteAdapter.MyViewHolder>(MoviesDiffUtil) {

    inner class MyViewHolder(val binding: ItemFavoruriteBinding): RecyclerView.ViewHolder(binding.root)

    object MoviesDiffUtil: DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemFavoruriteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = getItem(position)

        holder.binding.apply {
            tvName.text = product.name
            tvQuantity.text = product.quantityDescription
            ivImage.load(product.img)
            tvItemPrice.text = "$" + product.amount.toString()
        }

    }


}