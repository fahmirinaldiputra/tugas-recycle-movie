package com.mobile.latihan2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.latihan2.adapter.MovieAdapter
import com.mobile.latihan2.model.ModelMovie

class MovieActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var movieAdapter: MovieAdapter? = null
    private var movieList = mutableListOf<ModelMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie)

        movieList = ArrayList()
        recyclerView = findViewById(R.id.rv_movie)
        movieAdapter = MovieAdapter(this,movieList)

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager (
            this,2
        )

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = movieAdapter

        prepareMovieList()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rv_movie)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMovieList(){
        var movie = ModelMovie("avatar", R.drawable.avatar)
        movieList.add(movie)

        movie = ModelMovie("batman", R.drawable.batman)
        movieList.add(movie)

        movie = ModelMovie("spider man", R.drawable.spider_man)
        movieList.add(movie)

        movie = ModelMovie("hulk", R.drawable.hulk)
        movieList.add(movie)

        movie = ModelMovie("inception", R.drawable.inception)
        movieList.add(movie)

        movie = ModelMovie("jumanji", R.drawable.jumanji)
        movieList.add(movie)

        movie = ModelMovie("lucy", R.drawable.lucy)
        movieList.add(movie)

        movie = ModelMovie("jurassic world", R.drawable.jurassic_world)
        movieList.add(movie)

    }
}

