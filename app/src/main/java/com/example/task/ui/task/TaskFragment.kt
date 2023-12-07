package com.example.task.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task.App
import com.example.task.R
import com.example.task.databinding.FragmentTaskBinding
import com.example.task.model.TaskList
import com.example.task.ui.home.HomeFragment

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
        val task = arguments?.getSerializable(HomeFragment.TASK_KEY) as TaskList?
        if (task != null) {
            binding.save.text = getString(R.string.update)
            binding.etTitle.setText(task.title)
            binding.etDesc.setText(task.desc)
        }
        binding.save.setOnClickListener {
            if (!binding.etTitle.text
                    .isNullOrEmpty() && !binding.etDesc.text.isNullOrEmpty()
            ) {
                if (task != null) {
                    update(task)
                } else {
                    save()
                }
                findNavController().navigateUp()
            } else Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }
    }

    private fun update(task: TaskList) {
        App.db.taskDao().update(
            task.copy(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString()
            )
        )
    }

    private fun save() {
        val data = TaskList(
            title = binding.etTitle.text.toString(),
            desc = binding.etDesc.text.toString()
        )
        App.db.taskDao().insert(data)
    }

    companion object {
        const val TASK_KEY_R = "KEY_R"
        const val TASK_KEY = "KEY"
    }


}