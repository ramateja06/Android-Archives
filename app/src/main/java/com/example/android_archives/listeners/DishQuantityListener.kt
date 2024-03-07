package com.example.android_archives.listeners

import com.example.android_archives.model.DishModel

interface DishQuantityListener {
    fun onDecrementClick(data: DishModel, position: Int)
    fun onIncrementClick(data: DishModel, position: Int)
}