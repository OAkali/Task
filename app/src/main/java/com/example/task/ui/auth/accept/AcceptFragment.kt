package com.example.task.ui.auth.accept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task.R
import com.example.task.databinding.FragmentAcceptBinding
import com.example.task.ui.auth.phone.PhoneFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class AcceptFragment : Fragment() {
    private lateinit var binding:FragmentAcceptBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding= FragmentAcceptBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val verId=arguments?.getString(PhoneFragment.KEY)

        binding.btnConfirm.setOnClickListener {
            val credential = PhoneAuthProvider.getCredential(verId!!,binding.etCode.text.toString())
            signInWithPhoneAuthCredential(credential)
        }

    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnSuccessListener {
                findNavController().navigate(R.id.navigation_home)
                Toast.makeText(requireContext(),"Auth is success",Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener {
                Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
            }
    }
}