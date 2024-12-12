package com.capstone.foodescape.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.capstone.foodescape.services.CategoryService

object RetrofitClient {

    // The base URL of your API
    private const val BASE_URL = "http://34.50.64.6/ci3_api/index.php/"

    // Function to configure OkHttpClient with logging interceptor
    private fun getOkHttp(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    // Lazy initialization of Retrofit instance
    val instance: CategoryService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Base URL for API
            .client(getOkHttp()) // Add OkHttpClient
            .addConverterFactory(GsonConverterFactory.create()) // Gson converter to parse JSON
            .build()
            .create(CategoryService::class.java) // Create an instance of the CategoryService API
    }
}