package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurvey3Binding

class Survey3Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySurvey3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey3)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey3)

        binding.btnNext.setOnClickListener {
            var intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }
    }
}