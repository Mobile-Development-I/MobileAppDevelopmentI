package com.jaresi.wordle

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
            val guessedWord: TextView
            val checkField: TextView
            val guessNum: LinearLayout
            val checkGroup: LinearLayout

            if (guessCount == 0){
                guessNum = findViewById<LinearLayout>(R.id.firstGuess)
                checkGroup = findViewById<LinearLayout>(R.id.firstCheck)
                guessedWord = findViewById<TextView>(R.id.guess1)
                checkField = findViewById<TextView>(R.id.check1)
           }
            else if (guessCount == 1) {
                guessNum = findViewById<LinearLayout>(R.id.secondGuess)
                checkGroup = findViewById<LinearLayout>(R.id.secondCheck)
                guessedWord = findViewById<TextView>(R.id.guess2)
                checkField = findViewById<TextView>(R.id.check2)
            }
            else {
                guessNum = findViewById<LinearLayout>(R.id.thirdGuess)
                checkGroup = findViewById<LinearLayout>(R.id.thirdCheck)
                guessedWord = findViewById<TextView>(R.id.guess3)
                checkField = findViewById<TextView>(R.id.check3)
            }

            val gWord = guessField.text.toString().uppercase()
            guessedWord.text = gWord
            checkField.text = checkGuess(gWord)
            guessNum.visibility = View.VISIBLE
            checkGroup.visibility = View.VISIBLE
            guessedWord.visibility = View.VISIBLE
            checkField.visibility = View.VISIBLE
            guessField.text.clear()
            guessCount += 1
            closeKeyboard()
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

    private fun closeKeyboard() {
        // this will give us the view
        // which is currently focus
        // in this layout
        val view = this.currentFocus

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            val manager = getSystemService(
                INPUT_METHOD_SERVICE
            ) as InputMethodManager
            manager
                .hideSoftInputFromWindow(
                    view.windowToken, 0
                )
        }
    }
}