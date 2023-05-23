package com.example.test2.ui.car.resumeCars.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.test2.data.model.CarModel
import com.example.test2.databinding.CarItemBinding

class CarRecyclerViewHolder(private val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(car : CarModel, clickListener:(CarModel) -> Unit){
        binding.carNameTextView.text = car.name
        binding.carBrandTextView.text = car.brand
        binding.carDescriptionTextView.text = car.description

        binding.itemCardView.setOnClickListener{
            clickListener(car)
        }
    }

}