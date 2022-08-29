package com.example.menugen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.menugen.databinding.FragmentManagement1Binding
import com.example.menugen.databinding.FragmentSettingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Management_1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Management_1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // Activity 값을 가져오기 위한 선언 <------------------------------------ 여기부터
    private var _binding: FragmentManagement1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
        var meal = AutoLogin.getUserMeal(requireContext())

        // <밥>을 클릭했을 경우
        binding.tag1.setOnClickListener{
            // 소분류에 보여지면서 음식 제공
            val list1 = binding.List1
            list1.visibility = View.VISIBLE
            val list2 = binding.List2
            list2.visibility = View.VISIBLE
            val list3 = binding.List3
            list3.visibility = View.VISIBLE

            val list1a = binding.List1a
            list1a.setText("감자밥")
            val list2a = binding.List2a
            list2a.setText("검정콩밥")
            val list3a = binding.List3a
            list3a.setText("계란덥밥")
        }

        binding.tag2.setOnClickListener{
            // 소분류에 보여지면서 음식 제공
            val list1 = binding.List1
            list1.visibility = View.VISIBLE
            val list2 = binding.List2
            list2.visibility = View.VISIBLE
            val list3 = binding.List3
            list3.visibility = View.VISIBLE

            val list1a = binding.List1a
            list1a.setText("국수장국")
            val list2a = binding.List2a
            list2a.setText("군만두")
            val list3a = binding.List3a
            list3a.setText("김치만두")
        }

        binding.List1a.setOnClickListener{

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Management_1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Management_1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}