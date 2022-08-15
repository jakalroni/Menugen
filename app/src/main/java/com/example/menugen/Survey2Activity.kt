package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurvey2Binding

class Survey2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySurvey2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey2)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey2)

        binding.man.setOnClickListener {
            val intent = Intent(this, Survey3Activity::class.java)
            startActivity(intent)
        }
        binding.woman.setOnClickListener {
            val intent = Intent(this, Survey3Activity::class.java)
            startActivity(intent)
        }

    }
}