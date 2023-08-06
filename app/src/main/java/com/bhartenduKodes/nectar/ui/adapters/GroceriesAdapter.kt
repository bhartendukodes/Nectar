package com.bhartenduKodes.nectar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bhartenduKodes.nectar.databinding.LayoutGroceriesBinding
import com.bhartenduKodes.nectar.data.model.ProductCategory

class GroceriesAdapter:ListAdapter<ProductCategory, GroceriesAdapter.MyViewHolder>(groceriesDiffUtils) {

    inner class MyViewHolder(val binding: LayoutGroceriesBinding):RecyclerView.ViewHolder(binding.root)

    object groceriesDiffUtils:DiffUtil.ItemCallback<ProductCategory>() {
        override fun areItemsTheSame(oldItem: ProductCategory, newItem: ProductCategory): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductCategory, newItem: ProductCategory): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutGroceriesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            ivGroceryImage.load(item.image)
            tvGroceryName.text = item.name
            root.setCardBackgroundColor(ActivityCompat.getColor(root.context, item.bgColor))
        }
    }
}