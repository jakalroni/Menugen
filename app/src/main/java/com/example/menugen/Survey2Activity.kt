package com.example.menugen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.menugen.databinding.ActivitySurvey2Binding

class Survey2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySurvey2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey2)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_survey2)

//        binding.man.setOnClickListener {
//            val intent = Intent(this, Survey3Activity::class.java)
//            startActivity(intent)
//        }
//        binding.woman.setOnClickListener {
//            val intent = Intent(this, Survey3Activity::class.java)
//            startActivity(intent)
//        }

        val sex_itemList = listOf("성별을 선택하세요", "남자", "여자")
        val sex_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sex_itemList)
        binding.sexSpinner.adapter = sex_adapter

        binding.sexSpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position != 0) Toast.makeText(this@Survey2Activity, sex_itemList[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent:AdapterView<*>?) {}
        }

        val age_itemList = listOf("연령대를 선택하세요", "12-14", "15-18", "19-29", "30-49", "50-64", "65-74", "75세 이상")
        val age_adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, age_itemList)
        binding.ageSpinner.adapter = age_adapter

        binding.ageSpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position != 0) Toast.makeText(this@Survey2Activity, age_itemList[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent:AdapterView<*>?) {}
        }

        binding.btnNext.setOnClickListener {
            var intent = Intent(this, Survey3Activity::class.java)
            startActivity(intent)
        }

    }
}