package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurvey2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Survey2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySurvey2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        // 서버 연동코드
        val url = "http://220.149.236.48:27017/"
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var server = retrofit.create(JoinService::class.java)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey2)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey2)

        val sex_itemList = listOf("성별을 선택하세요", "남자", "여자")
        val sex_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sex_itemList)
        binding.sexSpinner.adapter = sex_adapter

        binding.sexSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) Toast.makeText(
                    this@Survey2Activity,
                    sex_itemList[position],
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val age_itemList =
            listOf("연령대를 선택하세요","6-8","9-11", "12-14", "15-18", "19-29", "30-49", "50-64", "65-74", "75세 이상")
        val age_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, age_itemList)
        binding.ageSpinner.adapter = age_adapter

        binding.ageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) Toast.makeText(
                    this@Survey2Activity,
                    age_itemList[position],
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        var intent = Intent(this, Survey3Activity::class.java)

        val uid = intent.getStringExtra("uid").toString()
        val upw = intent.getStringExtra("upw").toString()
        val uemail = intent.getStringExtra("uemail").toString()
        val uname = intent.getStringExtra("uname").toString()

        binding.btnNext.setOnClickListener {
            server.requestJoin(uid, upw, uname, uemail, 1, 1, 1, 1)
                .enqueue(object : Callback<Join> {
                    override fun onFailure(call: Call<Join>, t: Throwable) {
                        Log.d("회원가입 실패", "회원가입 실패 $uid, $upw, $uemail, $uname")
                    }

                    override fun onResponse(call: Call<Join>, response: Response<Join>) {
                        Log.d("회원가입 성공", "회원가입 성공 $uid, $upw, $uemail, $uname")
                        startActivity(intent)
                    }
                })

        }
    }
}
