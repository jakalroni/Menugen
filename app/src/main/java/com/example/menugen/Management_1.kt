package com.example.menugen

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.menugen.databinding.FragmentManagement1Binding
import com.example.menugen.databinding.FragmentSettingBinding
import java.lang.reflect.Member

class Management_1 : Fragment() {
    // Activity 값을 가져오기 위한 선언 <------------------------------------ 여기부터
    private var _binding: FragmentManagement1Binding? = null
    private val binding get() = _binding!!

    // 최종 음식 확인을 위한 변수
    val finalitems = mutableListOf<String>()
    val listAdapter = RVAdapter(finalitems)

    val activity:Recommend? = null

    // RecyclerView가 불러올 목록
    private var adapter:RVAdapter?=null
    private val data: MutableList<Member> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentManagement1Binding.inflate(inflater, container, false)
        val view = binding.root

        val recommend = activity as Recommend

        val btn_change = binding.tag3
        btn_change.setOnClickListener {
            recommend.changeFragment(2)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // var meal = AutoLogin.getUserMeal(requireContext())



        val recyclerview = view.findViewById<RecyclerView>(R.id.foodlist)
        val rvAdapter = RVAdapter(finalitems)
        recyclerview.adapter = rvAdapter

        /*
        rvAdapter.setItemClickListener(object : RVAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int){

            }
        })*/

        // <밥>을 클릭했을 경우
        binding.tag1.setOnClickListener{
            // 유동적인 리스트 생성을 위한 RecyclerView 객체와 변수들
            val items = mutableListOf<String>()
            items.add("감자밥(231g)")
            items.add("검정콩밥(200g)")
            items.add("계란덮밥(367g)")

            val rv = view.findViewById<RecyclerView>(R.id.foodlist)
            val rvAdapter = RVAdapter(items)

            rv.adapter = rvAdapter
            rv.layoutManager = LinearLayoutManager(context)
        }


        binding.tag2.setOnClickListener{
            // 유동적인 리스트 생성을 위한 RecyclerView 객체와 변수들
            val items = mutableListOf<String>()
            items.add("가지냉국(387g)")
            items.add("갈비탕(1136g)")
            items.add("감자된장국(528g)")

            val rv = view.findViewById<RecyclerView>(R.id.foodlist)
            val rvAdapter = RVAdapter(items)

            rv.adapter = rvAdapter
            rv.layoutManager = LinearLayoutManager(context)
        }


    }

    // https://juahnpop.tistory.com/235
    // 음식 목록의 음식 옆 추가 클릭 시 최종 음식 확인란에 추가되도록 하는 함수
    fun addList(position:Int, member: Member){
        val view = binding.root
        val finItem = mutableListOf<String>()

        //finItem.add(Member(String))

        val fin = view.findViewById<RecyclerView>(R.id.finallist)
        // val finAdapter = RVAdapter()
    }
}