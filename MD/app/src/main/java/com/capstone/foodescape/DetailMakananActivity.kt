package com.capstone.foodescape

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nisa.foodescape.databinding.ActivityDetailMakananBinding
import com.capstone.foodescape.model.Category

class DetailMakananActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMakananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMakananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the category object from the Intent
        val category = intent.getParcelableExtra<Category>("CATEGORY")

        // Check if the category object is not null
        if (category != null) {
            // Set category details in the UI
            binding.kategoriTempat.text = category.Kategori_Tempat
            binding.namaTempat.text = category.Nama_Tempat
            binding.kategoriMakanan.text = category.Kategori_Makanan
            binding.alamat.text = category.Alamat
            binding.review.text = category.Review
        }

        // Set up backButton click listener
        binding.backButton.setOnClickListener {
            onBackPressed()  // This will finish the current activity and return to the previous one
        }
    }

    // Optional: Override the onBackPressed method to customize back behavior if needed
    override fun onBackPressed() {
        super.onBackPressed()  // This will handle the back navigation to the previous activity
    }
}
