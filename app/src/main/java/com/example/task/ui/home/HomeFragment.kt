package com.example.task.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.task.R
import com.example.task.databinding.FragmentHomeBinding
import com.example.task.model.TaskList
import com.example.task.ui.home.adapter.TaskAdapter
import com.example.task.ui.task.TaskFragment
import com.example.task.ui.task.TaskFragment.Companion.TASK_KEY
import com.example.task.ui.task.TaskFragment.Companion.TASK_KEY_R

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter=TaskAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvhom.adapter=adapter
        setFragmentResultListener(TASK_KEY_R){_,bundle ->
            val data=bundle.getSerializable(TASK_KEY)as TaskList
            adapter.addTask(data)

        }
       binding.add.setOnClickListener {
           findNavController().navigate(R.id.taskFragment)
       }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}