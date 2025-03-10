package com.example.yorkfooddeals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        val etAdminUsername = findViewById<EditText>(R.id.etAdminUsername)
        val etAdminPassword = findViewById<EditText>(R.id.etAdminPassword)
        val btnAdminLogin = findViewById<Button>(R.id.btnAdminLogin)

        btnAdminLogin.setOnClickListener {
            val adminUser = etAdminUsername.text.toString().trim()
            val adminPass = etAdminPassword.text.toString().trim()

            // Check the credentials for Tim Hortons
            if (adminUser == "adminTim" && adminPass == "adminTim") {
                val timHortonsObject = Restaurant(
                    name = "Tim Hortons",
                    status = "Serving",
                    operatingHours = "8:00 AM - 7:00 PM",
                    menu = arrayListOf(
                        MenuItem("Coffee", "2.00", "1.50"),
                        MenuItem("Bagel", "3.00", "2.50")
                    ),
                    location = "Central Square"
                )

                val intent = Intent(this, AdminPanelActivity::class.java)
                // Pass the Restaurant object to AdminPanel
                intent.putExtra("restaurantData", timHortonsObject)
                startActivity(intent)
                finish()

                // Check the credentials for Starbucks
            } else if (adminUser == "adminStarbucks" && adminPass == "adminStarbucks") {
                val starbucksObject = Restaurant(
                    name = "Starbucks",
                    status = "Serving",
//                    normalPrice = "$6.00",
//                    discountPrice = "$4.00",
                    operatingHours = "7:00 AM - 8:00 PM",
                    menu = arrayListOf(
                        MenuItem("Latte", "4.00", "2.50"),
                        MenuItem("Sandwich", "5.00", "3.00")
                    ),
                    location = "Central Square"
                )

                val intent = Intent(this, AdminPanelActivity::class.java)
                intent.putExtra("restaurantData", starbucksObject)
                startActivity(intent)
                finish()

            } else if (adminUser == "adminOrangeSnail" && adminPass == "adminOrangeSnail") {

                val orangeSnail = Restaurant(
                    name = "Orange Snail",
                    status = "Serving",
                    operatingHours = "9:00 AM - 6:00 PM",
                    menu = arrayListOf(
                        MenuItem("Snail Burger", "$9.50", "$8.00"),
                        MenuItem("Rib Eye Steam Sandwich", "$10.50", "$5.00"),
                        MenuItem("Chicken Melt", "$9.75", "$7.00")
                    ),
                    location = "Stong College"
                )

                val intent = Intent(this, AdminPanelActivity::class.java)
                intent.putExtra("restaurantData", orangeSnail)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Invalid Admin Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
