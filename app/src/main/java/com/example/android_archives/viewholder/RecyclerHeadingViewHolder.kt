package com.example.android_archives.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_archives.databinding.ItemRecyclerHeaderBinding
import com.example.android_archives.model.RecyclerHeadingModel

class RecyclerHeadingViewHolder(private val binding: ItemRecyclerHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: RecyclerHeadingModel) {
        binding.tvRecyclerHeading.text = data.text
    }

    companion object {
        fun from(parent: ViewGroup): RecyclerHeadingViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemRecyclerHeaderBinding.inflate(inflater, parent, false)
            return RecyclerHeadingViewHolder(binding)
        }
    }
}