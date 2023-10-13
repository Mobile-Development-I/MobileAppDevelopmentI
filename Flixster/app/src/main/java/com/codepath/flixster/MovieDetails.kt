package com.codepath.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.codepath.flixster.GLOBAL.CURRENT_MOVIE
import com.codepath.flixster.GLOBAL.LIKED_MOVIES

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        findViewById<TextView>(R.id.title).text = CURRENT_MOVIE.title
        findViewById<TextView>(R.id.details).text = CURRENT_MOVIE.description

        Glide.with(findViewById<ImageView>(R.id.movie_image_large))
            .load("https://image.tmdb.org/t/p/w500/" + CURRENT_MOVIE.movieImageUrl)
            .placeholder(R.drawable.ic_android_black_24dp)
            .centerInside()
            .into(findViewById(R.id.movie_image_large))

        val likeButton = findViewById<ImageButton>(R.id.like_button)

        likeButton.setOnClickListener {
            CURRENT_MOVIE.liked = true
            Toast.makeText(this, "Liked: " + CURRENT_MOVIE.title, Toast.LENGTH_LONG).show()
            //LIKED_MOVIES.
        }
    }
}