package com.example.test2.ui.car.resumeCars.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.data.model.CarModel
import com.example.test2.databinding.CarItemBinding

class CarRecyclerAdapter(private val clickListener: (CarModel) ->Unit):
    RecyclerView.Adapter<CarRecyclerViewHolder>()
{

    // LISTA DE CARROS

    private val cars = ArrayList<CarModel>()


    // ON CREATE VIEW HOLDER (BINDING)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarRecyclerViewHolder {
       val binding = CarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarRecyclerViewHolder(binding)
    }

    // OBTENER LA CANTIDAD DE ITEMS

    override fun getItemCount(): Int =  cars.size

    // POSICION DE CADA CAR

    override fun onBindViewHolder(holder: CarRecyclerViewHolder, position: Int) {
        val car = cars[position]
        holder.bind(car, clickListener)
    }

    fun setData(carList: List<CarModel>){
        cars.clear()
        cars.addAll(carList)
    }

}