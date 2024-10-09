package com.zaqly.thebestmovie

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class page_details_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_details)
        supportActionBar?.hide()

        val movieTitle = intent.getStringExtra("movie_title")
        val movieGenre = intent.getStringExtra("movie_genre")
        val movieSynopsis = intent.getStringExtra("movie_synopsis")
        val movieImage = intent.getIntExtra("movie_image", 0) // Default 0 jika tidak ada gambar

        // Menghubungkan variabel dengan view yang ada di layout
        val titleTextView: TextView = findViewById(R.id.tv_page_details_name)
        val genreTextView: TextView = findViewById(R.id.tv_page_details_genre)
        val synopsisTextView: TextView = findViewById(R.id.tv_page_details_sinopsis)
        val movieImageView: ImageView = findViewById(R.id.img_page_details)

        // Mengisi view dengan data yang diterima
        titleTextView.text = movieTitle
        genreTextView.text = movieGenre
        synopsisTextView.text = movieSynopsis

        // Menampilkan gambar film
        movieImageView.setImageResource(movieImage)
    }
}
