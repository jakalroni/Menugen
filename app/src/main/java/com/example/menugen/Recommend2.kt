package com.example.menugen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Recommend2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend2)

        val getLargeMenu = intent.getStringExtra("large_menu")

//        Toast.makeText(this, getLargeMenu, Toast.LENGTH_LONG).show()

//        if(getLargeMenu == "1") {
//
//        }
    }
}