package com.example.khudhur.basketballapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.preference.PreferenceManager


class MainActivity : AppCompatActivity() {
    var leakerScore = 0
    var goldenScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        leakerScore = sharedPreference.getInt("LEAKERS_SCORE", 0)
        goldenScore = sharedPreference.getInt("GOLDEN_SCORE", 0)


        leakers1Button.setOnClickListener { leakersScore1() }
        leakers2Button.setOnClickListener { leakersScore2() }
        leakers3Button.setOnClickListener { leakersScore3() }
        golden1Button.setOnClickListener { goldenScore1() }
        golden2Button.setOnClickListener { goldenScore2() }
        golden3Button.setOnClickListener { goldenScore3() }
        fullTimeButton.setOnClickListener { fullTime() }
        resetButton.setOnClickListener { reset() }
    }

    override fun onStop() {
        super.onStop()
        val editor = PreferenceManager.getDefaultSharedPreferences(this).edit()
        editor.putInt("LEAKERS_SCORE",leakerScore)
        editor.putInt("GPLDEN_SCORE", goldenScore)
        editor.apply()

    }
    fun leakersScore1 (){
        leakerScore+= 1
        leakersTextView.text = leakerScore.toString()
    }
    fun leakersScore2 (){
        leakerScore+= 2
        leakersTextView.text = leakerScore.toString()
    }
    fun leakersScore3 (){
        leakerScore+= 3
        leakersTextView.text = leakerScore.toString()
    }
    fun goldenScore1 (){
        goldenScore += 1
        goldenTextView.text = goldenScore.toString()
    }
    fun goldenScore2 (){
        goldenScore += 2
        goldenTextView.text = goldenScore.toString()
    }
    fun goldenScore3 (){
        goldenScore += 3
        goldenTextView.text = goldenScore.toString()
    }
    fun fullTime (){
        var message : String? = null

        if (leakerScore == goldenScore)
            message = "It's a draw"
        else if (leakerScore> goldenScore)
            message = " la leakers won!"
        else
            message= "Golden State Warriors won!"
        Toast.makeText(this, message?.toString(),Toast.LENGTH_LONG).show()
    }
    fun reset (){
        leakerScore = 0
        goldenScore= 0
        leakersTextView.text =leakerScore.toString()
        goldenTextView.text = goldenScore.toString()
    }
}
