package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivityNutrientBinding

class NutrientActivity : AppCompatActivity() {

    // 데이터 바인딩
    private lateinit var binding: ActivityNutrientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrient)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_nutrient)

        // 닫기 버튼 눌러서 다시 추천액티비티로 복귀
        binding.btnClose.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }

        // 하단바 각각 액티비티로 이동
        binding.btnRecommend.setOnClickListener {
            val intent = Intent(this, Recommend::class.java)
            startActivity(intent)
        }
        binding.btnSetting.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        binding.btnInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

    }
}