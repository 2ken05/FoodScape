package com.capstone.foodescape.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nisa.foodescape.databinding.ItemCategoryBinding
import com.capstone.foodescape.model.Category
import com.nisa.foodescape.R

class CategoryAdapter(
    private var categories: List<Category>,
    private val onItemClick: (Category) -> Unit // Passing the entire Category object
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            // Set nama tempat
            binding.categoryName.text = category.Nama_Tempat

            // Set review (pastikan ada properti 'Review' dalam model)
            binding.categoryReview.text = category.Review

            // Load image using Glide
            Glide.with(binding.categoryImage.context)
                .load(category.ImageUrl) // URL gambar dari objek kategori
                .placeholder(R.drawable.streetfood2) // Gambar default
                .error(R.drawable.streetfood2) // Gambar jika load gagal
                .into(binding.categoryImage)

            // Set click listener
            binding.root.setOnClickListener {
                onItemClick(category) // Trigger the click listener and pass the entire category object
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    // Method to update data categories
    fun updateCategories(newCategories: List<Category>) {
        categories = newCategories
        notifyDataSetChanged()
    }
}
