package com.felipe.gradescalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.felipe.gradescalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            calculateGrade()
        }
    }

    private fun calculateGrade() {
        val grade1 = Integer.parseInt(binding.grade1Ipt.text.toString())
        val grade2 = Integer.parseInt(binding.grade2Ipt.text.toString())
        val grade3 = Integer.parseInt(binding.grade3Ipt.text.toString())
        val grade4 = Integer.parseInt(binding.grade4Ipt.text.toString())
        val missedClasses = Integer.parseInt(binding.missedClassesIpt.text.toString())
        var result = binding.resultDsp

        val average = (grade1 + grade2 + grade3 + grade4) / 4

        if (average >= 7 && missedClasses <= 20) {
            result.text = "Approved with average.\nAverage $average"
            result.setTextColor(getColor(R.color.green))
        } else if (missedClasses > 20) {
            result.text = "Failed for the number of missed classes.\nAverage $average"
            result.setTextColor(getColor(R.color.red))
        } else {
            result.text = "Failed with grade.\nAverage $average"
            result.setTextColor(getColor(R.color.red))
        }
    }
}