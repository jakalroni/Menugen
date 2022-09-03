package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    // 데이터 바인딩
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_info)

        // 로그아웃 버튼 - 동작처리 필요!!!
//        binding.btnLogout.setOnClickListener {
//            val intent = Intent(this, Management1Activity::class.java)
//            startActivity(intent)
//        }

        // 하단바 각각 액티비티로 이동
        binding.btnRecommend.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }
        binding.btnSetting.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        /*binding.btnInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }*/
    }
}