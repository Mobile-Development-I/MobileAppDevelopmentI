package com.jaresi.tapcounterapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addButton)
        val countView = findViewById<TextView>(R.id.countView)
        val upgradeButton = findViewById<Button>(R.id.upgradeButton)

        addButton.setOnClickListener {
            counter += 1
            countView.text = counter.toString()
            // Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()

            if (counter >= 100) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    addButton.text = "Add 2"
                    addButton.setOnClickListener {
                       counter += 2
                       countView.text = counter.toString()
                    }
                    upgradeButton.visibility = View.GONE
                }
            }
        }
    }
}