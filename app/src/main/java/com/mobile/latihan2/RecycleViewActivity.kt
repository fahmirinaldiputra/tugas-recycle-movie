package com.mobile.latihan2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.latihan2.adapter.BukuAdapter
import com.mobile.latihan2.model.ModelBuku

private lateinit var rev_data : RecyclerView
class RecycleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        rev_data = findViewById(R.id.rv_data)

        //kita array list
        //kita array list
        val listBuku = listOf(
            ModelBuku(judul = "Spiderman 1 20209", penulis = "Fahmi Rinaldi Putra"),
            ModelBuku(judul = "Spiderman  2 20208", penulis = "RFahmi Rinaldi Putra"),
            ModelBuku(judul = "Spiderman 3 20207", penulis = "Fahmi Rinaldi Putra"),
            ModelBuku(judul = "Harry Potter 4 20206", penulis = "Fahmi Rinaldi Putra"),
            ModelBuku(judul = "Harry Potter 5 20205", penulis = "Fahmi Rinaldi Putra"),
            ModelBuku(judul = "BHarry Potter 6 20204", penulis = "Fahmi Rinaldi Putra"),
            ModelBuku(judul = "Batman 7 20203", penulis = "Fahmi Rinaldi Putra"),

            )

        //baru kita set adapter
        val nBukuAdapter = BukuAdapter(listBuku)
        rev_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}