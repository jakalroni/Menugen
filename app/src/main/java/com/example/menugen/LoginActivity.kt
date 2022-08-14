package com.example.menugen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. 로그인 하기 버튼 클릭 시, 임시로 성공알림창 띄우기
        val btn_doLogin = findViewById<Button>(R.id.btn_doLogin)

        btn_doLogin.setOnClickListener {
            Toast.makeText(this, "정보 일치 가정, 로그인 성공!", Toast.LENGTH_LONG).show()

            // 2. 나중에 만들 메인 화면으로 넘어가기

        }

    }
}