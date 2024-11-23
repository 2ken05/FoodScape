package com.capstone.foodscape.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.capstone.foodscape.databinding.ActivityDetailStreetfoodBinding

class detail_streetfood : AppCompatActivity() {
    private lateinit var bind : ActivityDetailStreetfoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDetailStreetfoodBinding.inflate(layoutInflater)
        setContentView(bind.root)




        var j : String? = intent.getStringExtra("JUDUL berita")
        var I : String? = intent.getStringExtra("isi")
        var tgl : String? = intent.getStringExtra("Jam buka")


        Glide.with(this)
            .load("https://yyyz.000webhostapp.com/CI_Sekolah-master/assets/upload/${intent.getStringExtra("gambar berita")}")
            .into(bind.gmbar)


        bind.textView20.setText(j)
        bind.textView21.setText(tgl)
        bind.tvJustifiedParagraph.setText(I)



    }
}