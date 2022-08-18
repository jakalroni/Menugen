package com.example.menugen

import android.content.Intent
import android.content.SyncRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // 서버 연동
        val url = "http://220.149.236.48:27017/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val intent: Intent = Intent(this, Recommend::class.java)

        var server = retrofit.create(LoginService::class.java)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.doLogin.setOnClickListener {
            // 로그인 시 ID & PW 받아오기
            val uid : String = findViewById<EditText>(R.id.idEdit).text.toString()
            val upw : String = findViewById<EditText>(R.id.pwEdit).text.toString()

            // 서버로 ID & PW 보내기
            server.requestLogin(uid,upw).enqueue(object : Callback<Login>{
                override fun onFailure(call: Call<Login>, t:Throwable){
                    Log.d("로그인 실패","로그인 실패")
                }
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    val userlogin=response.body()
                    Log.d("코드", userlogin.toString())
                    // 가입된 계정이 아니면 X, 맞으면 다음 화면
                    if(userlogin?.code==200){
                        Log.d("로그인 성공", "로그인 성공 $uid, $upw")
                        startActivity(intent)
                    }
                    else{
                        //Log.d("로그인 실패", "로그인 실패")
                    }
                }

            })

        }

    }
}