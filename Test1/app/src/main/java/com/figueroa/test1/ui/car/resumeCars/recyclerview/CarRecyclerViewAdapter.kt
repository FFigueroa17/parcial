package com.figueroa.test1.ui.car.resumeCars.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.figueroa.test1.data.models.CarModel
import com.figueroa.test1.databinding.CarItemBinding

class CarRecyclerViewAdapter(private  val clickListener:(CarModel) -> Unit) : RecyclerView.Adapter<CarRecyclerViewHolder>() {


    // DECLRAR EL MODEL

    private val cars = ArrayList<CarModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarRecyclerViewHolder {

        val binding = CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: CarRecyclerViewHolder, position: Int) {
        val car = cars[position]
        holder.bind(car, clickListener)
    }

    fun setData(carsList: List<CarModel>){
        cars.clear()
        cars.addAll(carsList)
    }
}