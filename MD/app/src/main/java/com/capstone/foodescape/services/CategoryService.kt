package com.capstone.foodescape.services

import com.capstone.foodescape.model.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {
    @GET("Json/getcat")
    fun getAllCategories(
        @Query("Kategori_Tempat") kategoriTempat: String
    ): Call<CategoryResponse>
}
