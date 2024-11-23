package com.example.wisatadanberita

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisatadanberita.databinding.ActivityDashboardHomeBinding
import com.example.wisatadanberita.datas.DataItem
import com.example.wisatadanberita.datas.ResponseBerita
import com.example.wisatadanberita.network.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class dashboard_home : Fragment() {

    private var data: List<DataItem> = mutableListOf()
    private var adapter: adapter_berita? = null
    private var adapterw: adapterwisata? = null
    private lateinit var bind: ActivityDashboardHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bind = ActivityDashboardHomeBinding.inflate(inflater, container, false)
        bind.getRoot()
        bind.textView19.setOnClickListener {
            val i = Intent(context, list_berita::class.java)
            startActivity(i)
        }


        bind.rcBerita.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bind.rcBerita.itemAnimator = DefaultItemAnimator()
        bind.rcBerita.adapter = adapter
        bind.rcBerita.setHasFixedSize(true)

//        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
//        bind.rcBerita.setLayoutManager(layoutManager)

        // define an adapter

        // define an adapter
//        adapterr = adapter_berita( context)
//        recyclerView.setAdapter(mAdapter)
        // Inflate the layout for this fragment
        loadData()
        loadDatawisata()

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = adapter_berita(data)

        bind.rcBerita.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bind.rcBerita.itemAnimator = DefaultItemAnimator()
        bind.rcBerita.adapter = adapter
        bind.rcBerita.setHasFixedSize(true)
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

                        adapter = adapter_berita(data)
                        val linearLayoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        bind.rcBerita.setLayoutManager(linearLayoutManager)
                        bind.rcBerita.setAdapter(adapter);

                    }

                }
            })

    }

    private fun loadDatawisata() {
        api.getService()?.getwisata()
            ?.enqueue(object : Callback<ResponseBerita> {
                override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseBerita>,
                    response: Response<ResponseBerita>
                ) {
                    if (response.isSuccessful) {
                        data = response.body()?.data!!

                        adapterw = adapterwisata(data)
                        val linearLayoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        bind.rcwisata.setLayoutManager(linearLayoutManager)
                        bind.rcwisata.setAdapter(adapterw);

                    }

                }
            })

    }

//    fun setadapter (data : ArrayList<ResponseBerita>){
//        adapterr!!.setdata(data)
//    }
}


