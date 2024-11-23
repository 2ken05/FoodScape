package com.capstone.foodscape.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.foodscape.R
import com.capstone.foodscape.detail.detail_streetfood


class adapter_streetfood(private val model: List<DataItem>) :
    RecyclerView.Adapter<adapter_streetfood.ViewHolder>() {
    private var ct: Context? = null
    override fun onBindViewHolder(holder: adapter_streetfood.ViewHolder, position: Int) {
        val data = model[position]
        holder.tv_judul.text = data.judul//nampilkan judul

        holder.itemView.setOnClickListener {
            val I = Intent(holder.itemView.context, detail_streetfood::class.java)
            I.putExtra("JUDUL Street Food", data.judul)
            I.putExtra("isi streetfood", data.isi)
            I.putExtra("jam buka", data.jam_buka)
            I.putExtra("gambar streetfood", data.gambar)
            holder.itemView.getContext().startActivity(I)
        }

        ct?.let {

            Glide.with(it).load("https://yyyz.000webhostapp.com/CI_Sekolah-master/assets/upload/${data.gambar}")
                .into(holder.iv_gambar)
        }//menampilkan gambar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val L = LayoutInflater.from(parent.context)
        val V = L.inflate(R.layout.activity_adapter_streetfood, parent, false)
        ct = parent.context
        return ViewHolder(V)

    }

    override fun getItemCount(): Int {

        model.size <= 3
        return model.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_judul: TextView = itemView.findViewById(R.id.isi)


        internal var iv_gambar: ImageView = itemView.findViewById(R.id.img)
    }


}