package com.capstone.foodescape

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.foodescape.adapter.CategoryAdapter
import com.nisa.foodescape.databinding.ActivityMainBinding
import com.capstone.foodescape.model.Category
import com.capstone.foodescape.model.CategoryResponse
import com.capstone.foodescape.services.CategoryService
import com.capstone.foodescape.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private var allCategories: List<Category> = listOf()
    private var filteredCategories: List<Category> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView with the click listener
        categoryAdapter = CategoryAdapter(filteredCategories) { category ->
            // Handle item click to navigate to DetailMakananActivity
            val intent = Intent(this, DetailMakananActivity::class.java)
            intent.putExtra("CATEGORY", category) // Pass the entire category object
            startActivity(intent)
        }
        binding.recyclerViewCategories.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCategories.adapter = categoryAdapter

        fetchCategories()

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                val query = charSequence.toString()
                filterCategories(query)
            }

            override fun afterTextChanged(editable: Editable?) {}
        })
    }

    private fun fetchCategories() {
        val categoryService = RetrofitClient.instance
        val selectedCategory = intent.getStringExtra("SELECTED_CATEGORY") ?: ""

        categoryService.getAllCategories(selectedCategory).enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) {
                    allCategories = response.body()?.data ?: emptyList()
                    filteredCategories = allCategories
                    categoryAdapter.updateCategories(filteredCategories)
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {}
        })
    }

    private fun filterCategories(query: String) {
        filteredCategories = if (query.isEmpty()) {
            allCategories
        } else {
            allCategories.filter {
                it.Nama_Tempat.contains(query, ignoreCase = true) ||
                        it.Alamat.contains(query, ignoreCase = true)
            }
        }
        categoryAdapter.updateCategories(filteredCategories)
    }
}
