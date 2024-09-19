package com.mobile.latihan2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private lateinit var lv_data : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        lv_data = findViewById(R.id.lv_data)

        //list view
        //widget list view -> Array adapter --> Data source (Array/List/Adapter)

        //bikin array list
        val namaHewan = listOf(
            "gajah",
            "kuda",
            "beruang",
            "ular",
            "kucing",
            "sapi",
            "kerbau",
            "ikan"
        )
        //memasukan array ini kedalam adapter
        //anadroid layout --> layout bawaan untuk diadapter
        lv_data.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, namaHewan)

        //untuk bisa diklik dalam list
        lv_data.setOnItemClickListener(){
            parent, view, position, id ->
            Toast.makeText(this, "Anda Memilih : ${namaHewan[position]}",
                Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}