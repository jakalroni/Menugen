package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey)

        binding.btnNext.setOnClickListener {
            var intent = Intent(this, Survey2Activity::class.java)
            startActivity(intent)
        }
    }
}