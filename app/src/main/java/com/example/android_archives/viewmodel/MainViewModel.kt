package com.example.android_archives.viewmodel

import androidx.lifecycle.ViewModel
import com.example.android_archives.R
import com.example.android_archives.model.DishModel
import com.example.android_archives.model.RecyclerHeadingModel

class MainViewModel : ViewModel() {
    val data =
        listOf(
            RecyclerHeadingModel("Main Course"),
            DishModel(
                "Best Seller",
                R.drawable.ic_food,
                "Italian Spaghetti Exotic Veggie Pasta",
                19.0,
                "EUR",
                0
            ),
            DishModel(null, R.drawable.ic_food, "Palette", 25.0, "SAR", 0),
            DishModel(null, R.drawable.ic_food, "Veg Biryani", 499.0, "INR", 0),
            DishModel(null, R.drawable.ic_food, "Lasagne", 19.0, "GBP", 0),
            DishModel(
                "Selling fast",
                R.drawable.ic_food,
                "Crispy Corn Mayonnaise Sub",
                49.0,
                "CNY",
                0
            ),
            DishModel(null, R.drawable.ic_food, "Ramen", 100.0, "JPY", 0),
            RecyclerHeadingModel("Beverages"),
            DishModel("Healthy", R.drawable.ic_beverages, "Honey Moon", 999.0, "NZD", 0),
            DishModel(null, R.drawable.ic_beverages, "Apricot Delight", 299.0, "USD", 0),
            DishModel(null, R.drawable.ic_beverages, "Invalid Currency Code", 15.0, "Invalid", 0),
            DishModel(null, R.drawable.ic_beverages, "Negative amount", -15.0, "AUD", 0),
        )
}