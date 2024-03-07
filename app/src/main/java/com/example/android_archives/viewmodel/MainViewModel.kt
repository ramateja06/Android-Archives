package com.example.android_archives.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_archives.R
import com.example.android_archives.model.DishItem
import com.example.android_archives.model.DishModel
import com.example.android_archives.model.RecyclerHeadingModel

class MainViewModel : ViewModel() {
    private val _data = MutableLiveData<List<DishItem>>()
    val data: LiveData<List<DishItem>> = _data

    init {
        _data.value =
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
                DishModel(
                    null,
                    R.drawable.ic_beverages,
                    "Invalid Currency Code",
                    15.0,
                    "Invalid",
                    0
                ),
                DishModel(null, R.drawable.ic_beverages, "Negative amount", -15.0, "AUD", 0),
            )
    }

    fun decrementQuantity(value: DishModel, position: Int) {
        if (_data.value?.get(position) == value) {
            val newItem = value.copy(quantity = maxOf(value.quantity - 1, 0))
            val newList = _data.value?.toMutableList()?.apply {
                set(position, newItem)
            }
            _data.value = newList
        }
    }

    fun incrementQuantity(value: DishModel, position: Int) {
        if (_data.value?.get(position) == value) {
            val newItem = value.copy(quantity = value.quantity + 1)
            val newList = _data.value?.toMutableList()?.apply {
                set(position, newItem)
            }
            _data.value = newList
        }
    }
}