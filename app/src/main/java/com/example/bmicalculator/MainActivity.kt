package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var weight:TextView
    lateinit var height:TextView
    lateinit var calculate:Button

    lateinit var  result: TextView
    lateinit var info: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById(R.id.etWeight)
        height = findViewById(R.id.etHeight)
        calculate = findViewById(R.id.calcuate)


        calculate.setOnClickListener {
            val weight = weight.text.toString().toFloat()
            val height = height.text.toString().toFloat()
            val bmi = (weight / ((height/100.0) * (height/100.0)))
            displayValue(bmi)
            displayInfo(bmi)
        }
    }

    private fun displayInfo(bmi: Double) {
        // making this to display the values
        info = findViewById(R.id.tvResult)
        var text = ""
        if(bmi < 16.0)
            text = "Underweight (Severe thinness)"
        else if(bmi >= 16.0 && bmi <= 16.9)
            text = "Underweight (Moderate thinness)"
        else if(bmi >= 17.0 && bmi <= 18.4)
            text = "Underweight (Mild thinness)"
        else if(bmi >= 18.5 && bmi <= 24.9)
            text = "Normal range"
        else if(bmi >= 25.0 && bmi <= 29.9)
            text = "Overweight (Pre-obese)"
        else if(bmi >= 30.0 && bmi <= 34.9)
            text = "Obese (Class I)"
        else if(bmi >= 35.0 && bmi <= 39.9)
            text = "Obese (Class II)"
        else
            text = "Obese (Class III)"

        info.text = text // setting up the info
    }

    private fun displayValue(bmi: Double) {
        result = findViewById(R.id.tvIndex)
        result.text = String.format("%.2f",bmi).toFloat().toString()
    }
}