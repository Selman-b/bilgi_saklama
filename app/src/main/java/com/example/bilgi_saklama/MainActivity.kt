package com.example.bilgi_saklama

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bilgi_saklama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences
    var alinacakIsim :String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        sharedPreferences =this.getSharedPreferences("com.example.bilgi_saklama",
            Context.MODE_PRIVATE)//UYGULAMAYANIN VERILERINE BASKA UYGULAMA ERISEMEZ
        alinacakIsim = sharedPreferences.getString("isim","kullaniciGirdi")

    }


    fun kaydet(view :View){
        val kullaniciGirdi = binding.editTextText.text.toString()
        binding.textView.text = "Isminiz kaydedildi ! ${kullaniciGirdi}"
        sharedPreferences.edit().putString("isim",kullaniciGirdi).apply()
    }
    fun sil(view:View){

    }
}