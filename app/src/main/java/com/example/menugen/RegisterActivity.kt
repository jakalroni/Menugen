package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 1. 회원가입 완료 버튼 클릭 시, 임시로 성공알림창 띄우기
        val btn_doRegister = findViewById<Button>(R.id.btn_doRegister)
//        val name = findViewById<EditText>(R.id.name).toString()
//        val email = findViewById<EditText>(R.id.email).toString()
//        val password = findViewById<EditText>(R.id.password).toString()

        // 이름, 이메일, 비밀번호 유효성 검증 - 라이브러리, 함수, 정규식 등 여러 방법들이 있는데 구글링에선 다 코드 일부분만 있어 아직 다 구현 x
        btn_doRegister.setOnClickListener {
//            //이메일 유효성: android.util 에서 제공하는 기본 패턴을 이용하면 정규식을 쓰지 않고 간단히 검사할수있다.
//            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                Toast.makeText(this, "이메일 형식이 아닙니다", Toast.LENGTH_LONG).show()
//                return
//            }
//            //핸드폰번호 유효성
//            if (!Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", Phone_num)) {
//                Toast.makeText(this, "올바른 핸드폰 번호가 아닙니다.", Toast.LENGTH_SHORT).show()
//                return
//            }
//            //비밀번호 유효성
//            if (!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", PW)) {
//                Toast.makeText(this, "비밀번호 형식을 지켜주세요.", Toast.LENGTH_SHORT).show()
//                return

            Toast.makeText(this, "입력 검증 완료 가정, 회원가입 완료!", Toast.LENGTH_LONG).show()

            // 2. 설문 화면으로 넘어가기
            var intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }

    }
}