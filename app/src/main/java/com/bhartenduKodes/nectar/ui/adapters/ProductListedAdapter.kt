package com.bhartenduKodes.nectar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bhartenduKodes.nectar.data.dummydata.Actions
import com.bhartenduKodes.nectar.databinding.ListFindProductsBinding
import com.bhartenduKodes.nectar.data.model.ProductCategory
import com.bhartenduKodes.nectar.utils.extensions.click

class ProductListedAdapter(val onClick:(Actions)->Unit) :
    ListAdapter<ProductCategory, ProductListedAdapter.MyViewHolder>(ProductDiffUtils) {

    inner class MyViewHolder(val binding: ListFindProductsBinding) :
        RecyclerView.ViewHolder(binding.root)

    object ProductDiffUtils : DiffUtil.ItemCallback<ProductCategory>() {
        override fun areItemsTheSame(
            oldItem: ProductCategory,
            newItem: ProductCategory
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductCategory,
            newItem: ProductCategory
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListFindProductsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            ivGroceryImage.setImageResource(item.image)
            tvGroceryName.text = item.name
            root.setCardBackgroundColor(ActivityCompat.getColor(root.context, item.bgColor))
            root.click {
                onClick.invoke(item.action)
            }
        }
    }
}