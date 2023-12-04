package com.example.task.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task.App
import com.example.task.R
import com.example.task.databinding.FragmentHomeBinding
import com.example.task.model.TaskList
import com.example.task.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter=TaskAdapter(this::onLongClickItem,this::onClickItem)

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
        val data =App.db.taskDao().getAll()
        adapter.addTasks(data)
       binding.add.setOnClickListener {
           findNavController().navigate(R.id.taskFragment)
       }

    }
    private fun onLongClickItem(task: TaskList) {
        showAlertDialog(task)
    }
    private fun onClickItem(task: TaskList){
        findNavController().navigate(R.id.taskFragment, bundleOf( TASK_KEY to task))
    }

    private fun showAlertDialog(task: TaskList) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(task.title).setMessage("Вы точно хатите удалить ")
            .setCancelable(true).setPositiveButton("да") { _, _ ->
                App.db.taskDao().delete(task)
                val data = App.db.taskDao().getAll()
                adapter.addTasks(data)
            }
            .setNegativeButton("нет") { _, _ -> }.show()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        const val TASK_KEY="TASK"
    }
}