package com.example.yorkfooddeals

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val itemName: String,
    val itemPrice: String,      // Original (normal) price
    val discountPrice: String   // Price when discount is active
) : Parcelable
