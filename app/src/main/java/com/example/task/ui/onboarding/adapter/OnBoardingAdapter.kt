package com.example.task.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.task.databinding.ItemOnBoardingBinding
import com.example.task.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) : Adapter<OnBoardingAdapter.Holder>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding("" , " title1", "deck1"),
        OnBoarding(
            "https://static.wikia.nocookie.net/simpsons/images/0/02/Homer_Simpson_2006.png/revision/latest?cb=20141029075756&path-prefix=ru",
            " title2",
            "deck2"
        ),
        OnBoarding(
            "https://static.wikia.nocookie.net/simpsons/images/5/57/Lisa_Simpson2.png/revision/latest?cb=20140517140928&path-prefix=ru",
            " title3",
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
                    Glide.with(LAV).load(image).into(LAV)
                    next.isVisible = adapterPosition == list.lastIndex
                    skip.isVisible = adapterPosition != list.lastIndex
                    next.setOnClickListener { onClick() }
                    skip.setOnClickListener { onClick() }

                }
            }

        }
    }
}