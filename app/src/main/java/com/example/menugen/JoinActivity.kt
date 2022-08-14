package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        binding.idJoin.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }
    }
}