package com.example.task.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.task.App
import com.example.task.R
import com.example.task.databinding.FragmentTaskBinding
import com.example.task.model.TaskList

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.save.setOnClickListener {
            if (!binding.etTitle.text?.toString()
                    .isNullOrEmpty() && !binding.etDesc.text?.toString().isNullOrEmpty()
            ) {
                val data = TaskList(
                    title = binding.etTitle.text.toString(),
                    desc = binding.etDesc.text.toString()
                )
                App.db.taskDao().insert(data)
                findNavController().navigateUp()
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }


        }

    }

    companion object {
        const val TASK_KEY_R = "KEY_R"
        const val TASK_KEY = "KEY"
    }


}