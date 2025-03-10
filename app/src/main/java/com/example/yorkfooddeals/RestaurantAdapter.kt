package com.example.yorkfooddeals

import android.graphics.Paint
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(
    private val restaurantList: List<Restaurant>,
    private val onItemClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRestaurantName: TextView = itemView.findViewById(R.id.tvRestaurantName)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val tvMenuItems: TextView = itemView.findViewById(R.id.tvMenuItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurantList[position]
        holder.tvRestaurantName.text = restaurant.name
        holder.tvStatus.text = restaurant.status

        // Build a multiline string (or Spannable) of menu items
        val builder = SpannableStringBuilder()
        for (item in restaurant.menu) {
            builder.append(item.itemName + ": ")

            if (restaurant.status == "Serving on Discount") {
                // Strike out the original price
                val originalPrice = SpannableString("$${item.itemPrice}")
                originalPrice.setSpan(StrikethroughSpan(), 0, originalPrice.length, 0)
                builder.append(originalPrice)  // e.g.  ~~$5.00~~

                // Add " -> $2.00" (the discount price)
                builder.append(" → $${item.discountPrice}\n")
            } else {
                // Just show the normal price
                builder.append("$${item.itemPrice}\n")
            }
        }
        holder.tvMenuItems.text = builder

        // Click listener (go to RestaurantDetailsActivity, etc.)
        holder.itemView.setOnClickListener {
            onItemClick(restaurant)
        }
    }

    override fun getItemCount(): Int = restaurantList.size
}
