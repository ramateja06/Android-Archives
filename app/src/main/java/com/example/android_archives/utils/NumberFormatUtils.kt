package com.example.android_archives.utils

import java.text.NumberFormat
import java.util.Currency

fun Double.formatToAmount(currencyCode: String, decimalPlaces: Int = 2): String {
    return try {
        val formatter = NumberFormat.getCurrencyInstance()
        formatter.maximumFractionDigits = decimalPlaces
        formatter.currency = Currency.getInstance(currencyCode)
        formatter.format(this)
    } catch (e: Exception) {
        e.printStackTrace()
        val formatter = NumberFormat.getInstance()
        formatter.maximumFractionDigits = decimalPlaces
        formatter.format(this)
    }
}