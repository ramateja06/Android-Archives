package com.example.android_archives.model

import androidx.annotation.DrawableRes

data class DishModel(
    val specialInfo: String?,
    @DrawableRes val icon: Int,
    val dishName: String,
    val rate: Double,
    val currencyCode: String,
    val quantity: Int
) : DishItem

data class RecyclerHeadingModel(
    val text: String
) : DishItem

sealed interface DishItem