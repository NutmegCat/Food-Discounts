package com.example.yorkfooddeals

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminPanelActivity : AppCompatActivity() {
    private var restaurant: Restaurant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)

        val tvRestaurantNameAdmin = findViewById<TextView>(R.id.tvRestaurantNameAdmin)
        val switchDiscountStatus = findViewById<Switch>(R.id.switchDiscountStatus)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)

        // Retrieve the Restaurant (must be Parcelable)
        restaurant = intent.getParcelableExtra("restaurantData")

        restaurant?.let { r ->
            // Show the restaurant name
            tvRestaurantNameAdmin.text = "Restaurant: ${r.name}"

            // If the restaurant is "Serving on Discount," set the switch
            switchDiscountStatus.isChecked = (r.status == "Serving on Discount")
        }

        btnUpdate.setOnClickListener {
            // Update the restaurant status based on the toggle
            restaurant?.status = if (switchDiscountStatus.isChecked) {
                "Serving on Discount"
            } else {
                "Serving"
            }

            Toast.makeText(this, "Restaurant info updated!", Toast.LENGTH_SHORT).show()
        }

        // Optional: enable the ActionBar back arrow to "logout" or go back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Go back to AdminLoginActivity (logout)
                val intent = Intent(this, AdminLoginActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
