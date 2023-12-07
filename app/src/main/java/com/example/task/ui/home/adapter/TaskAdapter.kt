package com.example.task.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.task.databinding.ItemTaskBinding
import com.example.task.model.TaskList
import kotlin.reflect.KFunction1

class TaskAdapter(
    val onLongClickInt: (TaskList) -> Unit,
    val onClickInt: (TaskList) -> Unit
) : Adapter<TaskAdapter.Holder>() {

    private val list = arrayListOf<TaskList>()

    fun addTasks(tasks: List<TaskList>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    inner class Holder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: TaskList) {
            binding.apply {
                task.apply {
                    tvTask.text = title
                    tvDesc.text = desc
                }
            }
            itemView.setOnLongClickListener {
                onLongClickInt(task)
                true
            }
            itemView.setOnClickListener{
                onClickInt(task)
            }
        }
    }


}