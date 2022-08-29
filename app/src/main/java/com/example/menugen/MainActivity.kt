package com.example.menugen

// 메인화면 = 로그인 & 회원가입 버튼 창
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temp = arrayOf(arrayOf("밥류","쌀밥"), arrayOf("국류","된장국"), arrayOf("구이류","생선구이"), arrayOf("무침류","무침"))

        // 로그인, 회원가입 버튼 이동 시 LoginActivity, RegisterActivity로 이동
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_register = findViewById<Button>(R.id.btn_register)
        val btn_recommend = findViewById<Button>(R.id.btn_recommend)

        btn_login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btn_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_recommend.setOnClickListener {
            AutoLogin.setUserMeal(this@MainActivity, temp)
            Log.d("제발", temp.contentDeepToString())
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

    }
}