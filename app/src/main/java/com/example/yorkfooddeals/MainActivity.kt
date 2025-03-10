package com.example.yorkfooddeals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvRestaurants: RecyclerView
    private lateinit var restaurantAdapter: RestaurantAdapter
    private val restaurantList = ArrayList<Restaurant>()

    object RestaurantDataHolder {
        val restaurants = mutableListOf<Restaurant>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_main)

        rvRestaurants = findViewById(R.id.rvRestaurants)
        rvRestaurants.layoutManager = LinearLayoutManager(this)

        // Hardcode some restaurants for now, using arrayListOf(...) for the menu
        restaurantList.add(
            Restaurant(
                name = "Tim Hortons",
                status = "Status: Serving",
                operatingHours = "8:00 AM - 7:00 PM",
                menu = arrayListOf(
                    MenuItem("Coffee", "2.00", "1.50"),
                    MenuItem("Bagel", "3.00", "2.50")
                ),
                location = "Vari Hall"
            )
        )

        restaurantList.add(
            Restaurant(
                name = "Starbucks",
                status = "Status: Serving on Discount",
                operatingHours = "7:00 AM - 8:00 PM",
                menu = arrayListOf(
                    MenuItem("Latte", "4.00", "2.50"),
                    MenuItem("Sandwich", "5.00", "3.00")
                ),
                location = "Scott Library"
            )
        )

        restaurantList.add(
            Restaurant(
                name = "Orange Snail",
                status = "Status: Serving",
                operatingHours = "9:00 AM - 6:00 PM",
                menu = arrayListOf(
                    MenuItem("Snail Burger", "9.50", "8.00"),
                    MenuItem("Rib Eye Steam Sandwich", "10.50", "7.50"),
                    MenuItem("Chicken Melt", "9.75", "8.50")
                ),
                location = "York Lanes"
            )
        )

        restaurantAdapter = RestaurantAdapter(restaurantList) { restaurant ->
            // onItemClick
            val intent = Intent(this, RestaurantDetailsActivity::class.java)
            intent.putExtra("restaurantData", restaurant)
            startActivity(intent)
        }

        rvRestaurants.adapter = restaurantAdapter
    }
}
