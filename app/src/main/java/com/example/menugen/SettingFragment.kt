package com.example.menugen

// 식단관리 창
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.menugen.databinding.FragmentHomeBinding
import com.example.menugen.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    // Activity 값을 가져오기 위한 선언 <------------------------------------ 여기부터
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var meal = AutoLogin.getUserMeal(requireContext())
    }
    // <------------------------------------------ (feat. 석철)
}