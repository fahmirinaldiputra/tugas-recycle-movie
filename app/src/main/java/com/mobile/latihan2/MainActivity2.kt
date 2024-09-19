package com.mobile.latihan2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var txtWelcome : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        txtWelcome = findViewById(R.id.txtWelcome)
        //get data yang telah diinput ekstra intent

        val getDataUsername = intent.getStringExtra("username")
        val getDataPassword = intent.getStringExtra("password")

        //tampilkan hasil setelah di get
        txtWelcome.setText("Hello ${getDataUsername}!\n Password anda adalah : ${getDataPassword}")



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}