package com.example.menugen

// 식단추천 & 식단관리 & 내정보 Fragment 정보를 담을 창
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Recommend : AppCompatActivity() {
    // Fragment간 이동을 위한 변수
    lateinit var management1: Management_1
    lateinit var setting: SettingFragment

    // private val adapter = RVAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        // initLayout()

        val userall = intent.getStringExtra("alllist").toString()
        // val alltext = findViewById<TextView>(R.id.idEdit)
        // alltext.setText(userall)

        /*
        val temp = arrayOf(arrayOf("밥류","쌀밥"), arrayOf("국류","된장국"), arrayOf("구이류","생선구이"), arrayOf("무침류","무침"))
        val bundle:Bundle = Bundle()
        bundle.putString("식단", temp.toString())
        HomeFragment.arguments = bundle
         */

        // val temp = arrayOf(arrayOf("밥류","쌀밥"), arrayOf("국류","된장국"), arrayOf("구이류","생선구이"), arrayOf("무침류","무침"))
        // AutoLogin.setUserMeal(this@Recommend, temp)



        // 하단 탭이 눌렸을 때 화면을 전환하기 위한 객체 생성
        var bnv_main = findViewById(R.id.bottom_navigationview) as BottomNavigationView

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경
        bnv_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_container, homeFragment).commit()
                }
                R.id.setting -> {
                    val settingFragment = SettingFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_container, settingFragment).commit()
                }
                R.id.info -> {
                    val infoFragment = Management_1()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_container, infoFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.home
        }
    }

    // 뒤로가기 방지를 위한 변수
    private var doubleBackToExit = false

    // 뒤로가기 방지 및 두번 뒤로가기 시 종료
    override fun onBackPressed() {
        if(doubleBackToExit){
            finishAffinity()
        } else {
            Toast.makeText(this, "종료하시려면 뒤로가기를 한번 더 눌러주세요", Toast.LENGTH_SHORT).show()
            doubleBackToExit = true
            runDelayed(1500L){
                doubleBackToExit = false
            }
        }
    }

    // 뒤로가기를 일정시간 내에 두번 입력하는 것 감지하는 함수
    fun runDelayed(millis: Long, function: () -> Unit){
        Handler(Looper.getMainLooper()).postDelayed(function, millis)
    }

    // Fragment간 이동을 위한 함수
    fun changeFragment(index: Int){
        management1 = Management_1()
        setting = SettingFragment()
        when(index){
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_container, management1)
                    .commit()
            }

            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_container, setting)
                    .commit()
            }
        }
    }

    /*
    fun initLayout(){
        recyclerview
    }
     */
}