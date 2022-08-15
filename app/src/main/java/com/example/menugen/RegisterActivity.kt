package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.menugen.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameFocusListener()
        emailFocusListener()
        idFocusListener()
        passwordFocusListener()

//         1. 회원가입 완료 버튼 클릭 시, 임시로 성공알림창 띄우기
        binding.btnDoRegister.setOnClickListener {
            Toast.makeText(this, "입력 검증 완료 가정, 회원가입 완료!", Toast.LENGTH_LONG).show()
            // 2. 설문 화면으로 넘어가기
            var intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }

    }

    // 이름 유효성 검증
    private fun nameFocusListener() {
        binding.nameEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.nameContainer.helperText = validName()
            }
        }
    }

    private fun validName(): String?
    {
        val nameText = binding.nameEditText.text.toString()
        if(nameText.length < 2)
        {
            return "최소 2자 이상 입력해주세요."
        }
        if(!nameText.matches("^[a-zA-Z]*\$".toRegex()))
        {
            return "한글 및 영어만 입력해주세요."
        }
        return null
    }

    // 이메일 유효성 검증
    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText = binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "잘못된 이메일 형식입니다."
        }
        return null
    }

    // 아이디 유효성 검증
    private fun idFocusListener() {
        binding.idEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.idContainer.helperText = validId()
            }
        }
    }

    private fun validId(): String?
    {
        val idText = binding.idEditText.text.toString()
        if(idText.length < 6)
        {
            return "최소 6자 이상 입력해주세요."
        }
        if(!idText.matches("^[a-zA-Z0-9]*$".toRegex()))
        {
            return "영어 및 숫자만 입력해주세요."
        }
        return null
    }

    // 비밀번호 유효성 검증
    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.passwordEditText.text.toString()
        if(passwordText.length < 8)
        {
            return "최소 8자 이상 입력해주세요."
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "대문자 1개 이상을 포함해야합니다."
        }
        if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "소문자 1개 이상을 포함해야합니다."
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "특수문자 1개 이상을 포함해야합니다. (@#\$%^&+=)"
        }
        return null
    }


}