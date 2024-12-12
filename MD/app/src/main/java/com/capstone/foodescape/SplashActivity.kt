package com.capstone.foodescape

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.nisa.foodescape.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan layout activity_flash
        setContentView(R.layout.activity_flash)

        // Handler untuk menampilkan Splash screen selama 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Berpindah ke MainActivity setelah delay selesai
            val intent = Intent(this, PertanyaanActivity::class.java)
            startActivity(intent)
            finish() // Menutup SplashActivity
        }, 4000) // 2000 ms = 2 detik
    }
}
