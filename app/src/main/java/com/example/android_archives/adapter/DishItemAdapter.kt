package com.example.android_archives.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_archives.listeners.DishQuantityListener
import com.example.android_archives.model.DishItem
import com.example.android_archives.model.DishModel
import com.example.android_archives.model.RecyclerHeadingModel
import com.example.android_archives.viewholder.DishViewHolder
import com.example.android_archives.viewholder.RecyclerHeadingViewHolder

class DishItemAdapter(private val clickListener: DishQuantityListener) :
    ListAdapter<DishItem, RecyclerView.ViewHolder>(DishItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> RecyclerHeadingViewHolder.from(parent)
            1 -> DishViewHolder.from(parent)
            else -> throw IllegalStateException("Invalid viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RecyclerHeadingViewHolder -> holder.bind(getItem(position) as RecyclerHeadingModel)
            is DishViewHolder -> holder.bind(
                getItem(position) as DishModel,
                position,
                clickListener
            )
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is RecyclerHeadingModel -> 0
            is DishModel -> 1
        }
}

class DishItemDiffCallback : DiffUtil.ItemCallback<DishItem>() {
    override fun areItemsTheSame(oldItem: DishItem, newItem: DishItem): Boolean =
        when {
            oldItem is DishModel && newItem is DishModel ->
                oldItem.specialInfo == newItem.specialInfo &&
                        oldItem.dishName == newItem.dishName &&
                        oldItem.currencyCode == newItem.currencyCode &&
                        oldItem.rate == newItem.rate

            oldItem is RecyclerHeadingModel && newItem is RecyclerHeadingModel ->
                oldItem.text == newItem.text

            else -> false
        }

    override fun areContentsTheSame(oldItem: DishItem, newItem: DishItem): Boolean =
        oldItem == newItem

}