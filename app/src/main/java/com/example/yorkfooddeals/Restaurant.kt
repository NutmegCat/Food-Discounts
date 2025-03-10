package com.example.yorkfooddeals

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val name: String,
    var status: String,              // "Serving" or "Serving on Discount"
    val operatingHours: String,
    val menu: ArrayList<MenuItem>,   // Each MenuItem has both normal & discount prices
    val location: String
) : Parcelable
