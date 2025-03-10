package com.example.yorkfooddeals

import android.graphics.Paint
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RestaurantDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        val tvDetailName = findViewById<TextView>(R.id.tvDetailName)
        val tvDetailStatus = findViewById<TextView>(R.id.tvDetailStatus)
        val tvDetailOperatingHours = findViewById<TextView>(R.id.tvDetailOperatingHours)
        val tvDetailLocation = findViewById<TextView>(R.id.tvDetailLocation)

        // A new TextView in layout for the menu items
        val tvDetailMenu = findViewById<TextView>(R.id.tvDetailMenu)

        // Retrieve the Restaurant from the intent (Parcelable)
        val restaurant = intent.getParcelableExtra<Restaurant>("restaurantData")

        // Populate the UI
        restaurant?.let { r ->
            tvDetailName.text = r.name
            tvDetailStatus.text = "Status: ${r.status}"
            tvDetailOperatingHours.text = "Operating Hours: ${r.operatingHours}"
            tvDetailLocation.text = "Location: ${r.location}"

            // Build a display string for each MenuItem
            val builder = SpannableStringBuilder()
            for (item in r.menu) {
                // Format:  "ItemName:  ~~$X.XX~~ → $Y.YY"  if discount
                // Or just  "ItemName:  $X.XX" if normal
                builder.append("${item.itemName}: ")

                if (r.status == "Serving on Discount") {
                    // Strike out the original price
                    val originalPrice = SpannableString("$${item.itemPrice}")
                    originalPrice.setSpan(StrikethroughSpan(), 0, originalPrice.length, 0)

                    builder.append(originalPrice)   // e.g.  ~~$5.00~~
                    builder.append(" → $${item.discountPrice}\n")
                } else {
                    // No discount
                    builder.append("$${item.itemPrice}\n")
                }
            }
            // Put the entire menu string into tvDetailMenu
            tvDetailMenu.text = builder
        }
    }
}
