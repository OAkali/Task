package com.example.task.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.task.R
import com.example.task.data.local.Pref
import com.example.task.databinding.FragmentOnBoardingBinding
import com.example.task.ui.onboarding.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator


class OnBoardingFragment : Fragment() {
    private val adapter = OnBoardingAdapter(this::onClick)
    private lateinit var binding: FragmentOnBoardingBinding
    private val pref:Pref by lazy {
        Pref(requireContext())
    }

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
        binding.indicator.setViewPager(binding.ViewPager2)
    }
    private fun onClick(){
        pref.onBoardingShowed()
        findNavController().navigate(R.id.navigation_home)
    }

}

