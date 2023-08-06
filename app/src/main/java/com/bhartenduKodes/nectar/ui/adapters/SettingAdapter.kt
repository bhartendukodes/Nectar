package com.bhartenduKodes.nectar.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bhartenduKodes.nectar.databinding.SettingLayoutBinding
import com.bhartenduKodes.nectar.data.model.SettingData

class SettingAdapter : ListAdapter<SettingData, SettingAdapter.MyViewHolder>(SettingDiffUtils) {

    inner class MyViewHolder(val binding: SettingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    object SettingDiffUtils : DiffUtil.ItemCallback<SettingData>() {
        override fun areItemsTheSame(
            oldItem: SettingData,
            newItem: SettingData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SettingData,
            newItem: SettingData
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SettingLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            ivIcon.load(item.img)
            tvSettingName.text = item.name
        }

    }
}
