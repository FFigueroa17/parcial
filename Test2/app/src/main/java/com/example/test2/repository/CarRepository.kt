package com.example.test2.repository

import com.example.test2.data.model.CarModel

class CarRepository(private val cars: MutableList<CarModel>) {


   // AGREGAMOS LAS DOS FUNCIONES

    // OBTENER TODOS LOS CARROS
    fun getCars() = cars


    // AGREGAR CARROS
    fun addCars(car: CarModel) = cars. add(car)
}