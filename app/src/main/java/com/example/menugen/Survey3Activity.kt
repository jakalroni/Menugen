package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurvey3Binding

class Survey3Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySurvey3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey3)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey3)

        binding.age1.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        binding.age2.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        binding.age3.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        binding.age4.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        binding.age5.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        binding.age6.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        binding.age7.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

    }
}