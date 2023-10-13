package com.codepath.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepath.flixster.R.id

/**
 * The MainActivity for the Flixster app.
 * Launches a [MovieFragment].
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, MovieFragment(), null).commit()
    }
}