package com.example.task.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.task.R
import com.example.task.databinding.ItemOnBoardingBinding
import com.example.task.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) : Adapter<OnBoardingAdapter.Holder>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding(R.raw.animation_2, " title1", "deck1"),
        OnBoarding(R.raw.animation_1,
            " title2",
            "deck2"
        ),
        OnBoarding(R.raw.animation_3," title3",
            "deck3"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    inner class Holder(private val binding: ItemOnBoardingBinding) : ViewHolder(binding.root) {
        fun bind(boarding: OnBoarding) {
            binding.apply {
                boarding.apply {
                    title.text = name
                    lastName.text = last
                    boarding.image?.let { binding.ivBoard.setAnimation(it) }
                    
                    next.isVisible = adapterPosition == list.lastIndex
                    skip.isVisible = adapterPosition != list.lastIndex
                    next.setOnClickListener { onClick() }
                    skip.setOnClickListener { onClick() }

                }
            }

        }
    }
}