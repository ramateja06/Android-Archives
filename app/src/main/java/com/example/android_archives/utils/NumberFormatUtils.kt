package com.example.android_archives.utils

import java.text.NumberFormat
import java.util.Currency

fun Double.formatToAmount(currencyCode: String, decimalPlaces: Int = 2): String {
    val formatter = NumberFormat.getCurrencyInstance()
    formatter.maximumFractionDigits = decimalPlaces

    try {
        formatter.currency = Currency.getInstance(currencyCode)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return formatter.format(this)
}