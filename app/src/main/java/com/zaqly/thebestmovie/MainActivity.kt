package com.zaqly.thebestmovie

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovie: RecyclerView
    private val list = ArrayList<Movie>()
    lateinit var name: Array<String>
    lateinit var genre: Array<String>
    lateinit var sinopsis: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovie = findViewById(R.id.rv_movies)
        rvMovie.setHasFixedSize(true)

        list.addAll(getListMovie())
        showRecyclerList()
    }
    private fun getListMovie(): ArrayList<Movie> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSinopsis = resources.getStringArray(R.array.data_sinopsis)

        val listMovie = ArrayList<Movie>()
        for (i in dataName.indices) {
            val movie = Movie(dataName[i], dataGenre[i],dataPhoto.getResourceId(i, -1),dataSinopsis[i])
            listMovie.add(movie)
        }
        dataPhoto.recycle()
        return listMovie
    }
    private fun showRecyclerList() {
        rvMovie.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovie.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : ListMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movie) {
                showSelectedMovie(data)
            }
        })
    }
    private fun showSelectedMovie(movie: Movie) {
//        Toast.makeText(this, "Kamu memilih " + movie.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, page_details_activity::class.java)
        intent.putExtra("movie_title", movie.name)  // Pass movie title
        intent.putExtra("movie_genre", movie.genre) // Pass movie genre
        intent.putExtra("movie_synopsis", movie.sinopsis) // Pass movie synopsis
        intent.putExtra("movie_image", movie.photo) // Assuming you have an image resource ID for the movie
        startActivity(intent)//
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Intent untuk berpindah ke halaman About
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}