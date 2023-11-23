package com.example.task.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.task.R
import com.example.task.databinding.FragmentOnBoardingBinding
import com.example.task.ui.onboarding.adapter.OnBoardingAdapter


class OnBoardingFragment : Fragment() {
    private val adapter = OnBoardingAdapter(this::onClick)
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ViewPager2.adapter = adapter
    }
    private fun onClick(){
        findNavController().navigate(R.id.navigation_home)
    }

}