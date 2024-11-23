package com.capstone.foodscape.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.foodscape.R


class adaptersheet(private val model: List<SheetResponseItem>) :
    RecyclerView.Adapter<adaptersheet.ViewHolder>() {
    private var ct: Context? = null
    override fun onBindViewHolder(holder: adaptersheet.ViewHolder, position: Int) {
        val data = model[position]
        holder.tv_judul.text = data.akhmad//nampilkan judul


        holder.itemView.setOnClickListener {

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val L = LayoutInflater.from(parent.context)
        val V = L.inflate(R.layout.activity_adaptersheet, parent, false)
        ct = parent.context
        return ViewHolder(V)

    }

    override fun getItemCount(): Int {

        model.size <= 3
        return model.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_judul: TextView = itemView.findViewById(R.id.fah)


        internal var iv_gambar: ImageView = itemView.findViewById(R.id.img)
    }


}