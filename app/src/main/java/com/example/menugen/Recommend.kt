package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Recommend : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        val large_menu1 = findViewById<LinearLayout>(R.id.large_menu1)
        val large_menu2 = findViewById<LinearLayout>(R.id.large_menu2)
        val large_menu3 = findViewById<LinearLayout>(R.id.large_menu3)
        val large_menu4 = findViewById<LinearLayout>(R.id.large_menu4)


        large_menu1.setOnClickListener {
            val intent = Intent(this, Recommend2::class.java)
            intent.putExtra("large_menu", "1")
            startActivity(intent)
        }

        large_menu2.setOnClickListener {
            val intent = Intent(this, Recommend2::class.java)
            intent.putExtra("large_menu", "2")
            startActivity(intent)
        }

        large_menu3.setOnClickListener {
            val intent = Intent(this, Recommend2::class.java)
            intent.putExtra("large_menu", "3")
            startActivity(intent)
        }

        large_menu4.setOnClickListener {
            val intent = Intent(this, Recommend2::class.java)
            intent.putExtra("large_menu", "4")
            startActivity(intent)
        }
    }
}