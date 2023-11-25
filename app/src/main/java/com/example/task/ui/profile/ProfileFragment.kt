package com.example.task.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.task.R
import com.example.task.data.local.Pref
import com.example.task.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
   private lateinit var binding:FragmentProfileBinding
   private val pref:Pref by lazy {
       Pref(requireContext())
   }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText(pref.getName() )
        binding.etName.addTextChangedListener {
            pref.saveName(binding.etName.text.toString())
        }
    }

}