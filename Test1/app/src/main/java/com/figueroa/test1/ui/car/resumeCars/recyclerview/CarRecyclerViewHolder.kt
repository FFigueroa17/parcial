package com.figueroa.test1.ui.car.resumeCars.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.figueroa.test1.data.models.CarModel
import com.figueroa.test1.databinding.CarItemBinding

class CarRecyclerViewHolder(private val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind ( car: CarModel , clickListener: (CarModel) -> Unit){

        binding.carNameTextView.text = car.name
        binding.carBrandTextView.text = car.brand
        binding.carYearTextView.text = car.year.toString()
        binding.carDescriptionTextView.text = car.description
        binding.carPriceTextView.text = car.price.toString()

        binding.carCardView.setOnClickListener {
            clickListener(car)
        }
    }
}