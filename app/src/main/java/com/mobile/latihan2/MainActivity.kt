package com.mobile.latihan2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var eUser : EditText
    private lateinit var ePassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnList : Button
    private lateinit var  btnRecycle : Button
    private lateinit var  btnRecycleBuah : Button
    private lateinit var  btnRecycleMovie : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        btnList = findViewById(R.id.btnList)
        eUser = findViewById(R.id.eUser)
        ePassword = findViewById(R.id.ePassword)
        btnRecycle = findViewById(R.id.btnRecycle)
        btnRecycleBuah = findViewById(R.id.btnRecycleBuah)
        btnRecycleMovie = findViewById(R.id.btnRecycleMovie)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin.setOnClickListener(){
            val username = eUser.text.toString()
            val password = ePassword.text.toString()

            val intentPassingData = Intent(this@MainActivity,MainActivity2::class.java)


            //proses put data
            intentPassingData.putExtra("username",username)
            intentPassingData.putExtra("password",password)

            //cek data ada apa tidak, LOGCAT
            Log.d("cek data username", username)
            Log.d("cek data password", password)

            //pindah  dan membawa datanya
            startActivity(intentPassingData)
        }

        btnList.setOnClickListener(){
            val intentPassingData = Intent(this@MainActivity,MainActivity3::class.java)
            startActivity(intentPassingData)
        }
        btnRecycle.setOnClickListener(){
            val intentPassingData = Intent(this@MainActivity,RecycleViewActivity::class.java)
            startActivity(intentPassingData)
        }
        btnRecycleBuah.setOnClickListener(){
            //intent --> pindah dari satu activity ke activity lain
            //intent implicit : pindah yg ada project
            //intent expilicit : pindah keluar app dan manggil apps lain
            val intentMenu2 = Intent(this@MainActivity,
                RecycleBuahActivity::class.java)
            startActivity(intentMenu2)
        }
        btnRecycleMovie.setOnClickListener(){
            //intent --> pindah dari satu activity ke activity lain
            //intent implicit : pindah yg ada project
            //intent expilicit : pindah keluar app dan manggil apps lain
            val intentMenu2 = Intent(this@MainActivity,
                MovieActivity::class.java)
            startActivity(intentMenu2)
        }

    }
}