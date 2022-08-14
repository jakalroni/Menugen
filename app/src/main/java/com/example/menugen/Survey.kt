package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurveyBinding

class Survey : AppCompatActivity() {

    private lateinit var binding: ActivitySurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey)

        binding.habit.setOnClickListener {
            val intent = Intent(this, survey2::class.java)
            startActivity(intent)
        }

        binding.disease.setOnClickListener {
            val intent = Intent(this, survey2::class.java)
            startActivity(intent)
        }

        binding.diet.setOnClickListener {
            val intent = Intent(this, survey2::class.java)
            startActivity(intent)
        }
    }
}


