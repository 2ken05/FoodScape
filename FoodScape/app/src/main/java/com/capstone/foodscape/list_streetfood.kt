package com.capstone.foodscape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.foodscape.adapter.adapter_streetfood
import com.capstone.foodscape.databinding.ActivityListStreetfoodBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class list_streetfood : AppCompatActivity() {

    private var data: List<DataItem> = mutableListOf()
    private var adapter: adapter_streetfood? = null
    private lateinit var bind: ActivityListStreetfoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityListStreetfoodBinding.inflate(layoutInflater)
        setContentView(bind.root)
        loadData()
    }
    private fun loadData() {
        api.getService()?.getberita()
            ?.enqueue(object : Callback<ResponseBerita> {
                override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseBerita>,
                    response: Response<ResponseBerita>
                ) {
                    if (response.isSuccessful) {
                        data = response.body()?.data!!

                        adapter = adapter_streetfood(data)
                        val linearLayoutManager =
                            LinearLayoutManager(this@list_streetfood, LinearLayoutManager.VERTICAL, false)
                        bind.rcstreetfood.setLayoutManager(linearLayoutManager)
                        bind.rcstreetfood.setAdapter(adapter);

                    }

                }
            })

    }
}