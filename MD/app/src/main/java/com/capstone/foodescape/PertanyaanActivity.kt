package com.capstone.foodescape

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity
import com.nisa.foodescape.R

class PertanyaanActivity : AppCompatActivity() {

    private lateinit var radioGroupTempat: RadioGroup
    private lateinit var submitButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_pertanyaan)

        // Initialize the views
        radioGroupTempat = findViewById(R.id.radioGroupTempat)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            // Get the selected radio button ID
            val selectedRadioButtonId = radioGroupTempat.checkedRadioButtonId

            if (selectedRadioButtonId != -1) {
                // Get the text of the selected radio button
                val selectedCategory = findViewById<RadioButton>(selectedRadioButtonId).text.toString()

                // Pass the selected category to MainActivity2
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("SELECTED_CATEGORY", selectedCategory)
                startActivity(intent)
            } else {
                // Handle case where no radio button is selected
                Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish() // Close the current activity and exit the app
    }
}
