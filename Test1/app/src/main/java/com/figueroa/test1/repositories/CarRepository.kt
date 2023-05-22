package com.figueroa.test1.repositories

import com.figueroa.test1.data.models.CarModel

// TODO: 1. Create a class CarRepository with a MutableList of CarModel as a constructor parameter.

class CarRepository(private val cars: MutableList<CarModel>){

    // TODO: 2. Create a function getCars() that returns the list of cars.
    fun getCars() = cars

    // TODO: 3. Create a function addCar(car: CarModel) that adds a new car to the list of cars.
    fun addCar(car: CarModel) = cars.add(car)
}