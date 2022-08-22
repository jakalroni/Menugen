package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.*
import com.example.menugen.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // 서버 연동코드
        val url = "http://220.149.236.48:27017/"
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var server = retrofit.create(LoginReduple::class.java)

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameFocusListener()
        emailFocusListener()
        idFocusListener()
        passwordFocusListener()

        // 아이디 중복확인
        var duplepoint = 400
        binding.duplebtn.setOnClickListener{
            val uid : String = findViewById<EditText>(R.id.UidEditText).text.toString()

            server.requestLoginReduple(uid).enqueue(object : Callback<Reduple>{
                override fun onFailure(call: Call<Reduple>, t: Throwable) {
                    Log.d("실패", "정보 $uid")
                }
                // 성공 시
                override fun onResponse(call: Call<Reduple>, response: Response<Reduple>) {
                    val duplecheck=response.body()
                    Log.d("코드", duplecheck.toString())
                    // 가입된 계정이 아니면 X, 맞으면 다음 화면
                    if(duplecheck?.code==200){
                        duplepoint = duplecheck.code
                        Log.d("로그인 성공", "로그인 성공 $duplecheck, $duplepoint")
                    }
                    else{
                        Toast.makeText(this@RegisterActivity, "아이디 중복검사를 진행해주세요!", Toast.LENGTH_LONG).show()
                    }
                }
            })
        }

        // 1. 회원가입 완료 버튼 클릭 시, 임시로 성공알림창 띄우기
        binding.btnDoRegister.setOnClickListener {
            val uid : String = findViewById<EditText>(R.id.UidEditText).text.toString()
            val upw : String = findViewById<EditText>(R.id.UpwEditText).text.toString()
            val uemail : String = findViewById<EditText>(R.id.UemailEditText).text.toString()
            val uname : String = findViewById<EditText>(R.id.UnameEditText).text.toString()

            // 2. 설문 화면으로 넘어가기
            var intent = Intent(this, SurveyActivity::class.java)
            // 회원정보 다음화면(설문)으로 넘기기
            intent.putExtra("uid",uid)
            intent.putExtra("upw",upw)
            intent.putExtra("uemail",uemail)
            intent.putExtra("uname",uname)
            Log.d("성공", "성공 $uid, $upw, $uemail, $uname")

            // 다음 화면 and 빈칸 존재 시 예외처리
            if(uid != "" || upw != "" || uemail != "" || uname != ""){
                // ID 중복 확인 시 중복된 아이디가 아니면
                if(duplepoint == 200){
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "아이디 중복검사를 진행해주세요!", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "빈칸을 모두 채워주세요!", Toast.LENGTH_LONG).show()
            }
        }
    }
    // ---------------------------------------디자인-------------------------------------------

    // 이름 유효성 검증
    private fun nameFocusListener() {
        binding.UnameEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.nameContainer.helperText = validName()
            }
        }
    }

    private fun validName(): String?
    {
        val nameText = binding.UnameEditText.text.toString()
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
        binding.UemailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText = binding.UemailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "잘못된 이메일 형식입니다."
        }
        return null
    }

    // 아이디 유효성 검증
    private fun idFocusListener() {
        binding.UidEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.idContainer.helperText = validId()
            }
        }
    }

    private fun validId(): String?
    {
        val idText = binding.UidEditText.text.toString()
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

    // 비밀번호 유효성 검증 + 이름 간단히 변경
    private fun passwordFocusListener() {
        binding.UpwEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.UpwEditText.text.toString()
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