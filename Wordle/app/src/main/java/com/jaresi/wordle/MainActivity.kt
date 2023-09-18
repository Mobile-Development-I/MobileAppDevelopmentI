package com.jaresi.wordle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var guesses = emptyList<String>()
    var guessCount = 0
    val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var correctWord = findViewById<TextView>(R.id.correctWord)
        var guessField = findViewById<EditText>(R.id.guessField)
        var submitButton = findViewById<Button>(R.id.submitButton)

        //correctWord.text = ""
        correctWord.text = FourLetterWordList.getRandomFourLetterWord()

        submitButton.setOnClickListener {
            var guessedWord: TextView
            var checkField: TextView

            if (guessCount == 0){
                guessedWord = findViewById<TextView>(R.id.guess1)
                checkField = findViewById<TextView>(R.id.check1)
           }
            else if (guessCount == 1) {
                guessedWord = findViewById<TextView>(R.id.guess2)
                checkField = findViewById<TextView>(R.id.check2)
            }
            else {
                guessedWord = findViewById<TextView>(R.id.guess3)
                checkField = findViewById<TextView>(R.id.check3)
            }

            val gWord = guessField.text.toString()
            guessedWord.text = gWord
            checkField.text = checkGuess(gWord)
            guessedWord.visibility = View.VISIBLE
            checkField.visibility = View.VISIBLE
            guessField.text.clear()
            guessCount += 1
        }
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

    private fun reset(guessField: EditText){
        guessField.text.clear()
    }
}