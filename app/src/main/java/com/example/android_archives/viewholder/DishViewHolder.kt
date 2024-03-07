package com.example.android_archives.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_archives.databinding.ItemDishRowBinding
import com.example.android_archives.listeners.DishQuantityListener
import com.example.android_archives.model.DishModel
import com.example.android_archives.utils.formatToAmount

class DishViewHolder(private val binding: ItemDishRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: DishModel, position: Int, clickListener: DishQuantityListener) {
        if (data.specialInfo.isNullOrEmpty()) {
            binding.tvSpecialInfo.text = ""
            binding.tvSpecialInfo.visibility = View.GONE
        } else {
            binding.tvSpecialInfo.text = data.specialInfo
            binding.tvSpecialInfo.visibility = View.VISIBLE
        }

        binding.imgIcon.setImageResource(data.icon)
        binding.tvDishName.text = data.dishName
        binding.tvQuantity.text = data.quantity.toString()
        binding.tvRate.text = data.rate.formatToAmount(data.currencyCode)

        binding.btnDecrementQty.setOnClickListener {
            clickListener.onDecrementClick(data, position)
        }

        binding.btnIncrementQty.setOnClickListener {
            clickListener.onIncrementClick(data, position)
        }
    }

    companion object {
        fun from(parent: ViewGroup): DishViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemDishRowBinding.inflate(inflater, parent, false)
            return DishViewHolder(binding)
        }
    }
}