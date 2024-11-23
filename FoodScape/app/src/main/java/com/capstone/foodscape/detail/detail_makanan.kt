package com.capstone.foodscape.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.capstone.foodscape.databinding.ActivityDetailMakananBinding


class detail_makanan : AppCompatActivity() {
    private lateinit var bind : ActivityDetailMakananBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailMakananBinding.inflate(layoutInflater)
        setContentView(bind.root)




        var j : String? = intent.getStringExtra("JUDUL")
        var I : String? = intent.getStringExtra("isi")
        var tiket : String? = intent.getStringExtra("tiket")
        var lokasi : String? = intent.getStringExtra("lokasi")

        Glide.with(this)
            .load("https://yyyz.000webhostapp.com/CI_Sekolah-master/assets/upload/${intent.getStringExtra("gambar")}")
            .into(bind.gmbar)


        bind.juduul.setText(j)
        bind.textView24.setText(tiket)
        bind.tvJustifiedParagraph.setText(I)
        bind.textView25.setText(lokasi)


    }
}