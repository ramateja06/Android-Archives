package com.example.android_archives.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_archives.listeners.DishQuantityListener
import com.example.android_archives.model.DishItem
import com.example.android_archives.model.DishModel
import com.example.android_archives.model.RecyclerHeadingModel
import com.example.android_archives.viewholder.DishViewHolder
import com.example.android_archives.viewholder.RecyclerHeadingViewHolder

class DishItemAdapter(private val clickListener: DishQuantityListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<DishItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> RecyclerHeadingViewHolder.from(parent)
            1 -> DishViewHolder.from(parent)
            else -> throw IllegalStateException("Invalid viewType")
        }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RecyclerHeadingViewHolder -> holder.bind(data[position] as RecyclerHeadingModel)
            is DishViewHolder -> holder.bind(data[position] as DishModel, position, clickListener)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (data[position]) {
            is RecyclerHeadingModel -> 0
            is DishModel -> 1
        }

    fun setData(value: List<DishItem>) {
        data.clear()
        data.addAll(value)
        notifyDataSetChanged()
    }

    fun updateSingleItem(data: DishItem, position: Int) {
        this.data[position] = data
        notifyItemChanged(position)
    }
}