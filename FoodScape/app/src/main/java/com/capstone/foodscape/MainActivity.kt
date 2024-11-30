package com.capstone.foodscape

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import com.capstone.foodscape.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            val splsh = Intent(this, login::class.java)
            startActivity(splsh)
            finish()

        }, 4000)}
}