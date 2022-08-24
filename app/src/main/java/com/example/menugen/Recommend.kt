package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class Recommend : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        /*
        val large_menu1 = findViewById<LinearLayout>(R.id.large_menu1)
        val large_menu2 = findViewById<LinearLayout>(R.id.large_menu2)
        val large_menu3 = findViewById<LinearLayout>(R.id.large_menu3)
        val large_menu4 = findViewById<LinearLayout>(R.id.large_menu4)
        */

        val userall = intent.getStringExtra("alllist").toString()
        // val alltext = findViewById<TextView>(R.id.idEdit)
        // alltext.setText(userall)

        /*
        large_menu1.setOnClickListener {
            val newintent = Intent(this, Recommend2::class.java)
            newintent.putExtra("large_menu", "1")
            startActivity(newintent)
        }

        large_menu2.setOnClickListener {
            val newintent = Intent(this, Recommend2::class.java)
            newintent.putExtra("large_menu", "2")
            startActivity(newintent)
        }

        large_menu3.setOnClickListener {
            val newintent = Intent(this, Recommend2::class.java)
            newintent.putExtra("large_menu", "3")
            startActivity(newintent)
        }

        large_menu4.setOnClickListener {
            val newintent = Intent(this, Recommend2::class.java)
            newintent.putExtra("large_menu", "4")
            startActivity(newintent)
        }
        */
    }
}