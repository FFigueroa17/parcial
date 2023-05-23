package com.example.test2

import android.app.Application
import com.example.test2.data.carList
import com.example.test2.repository.CarRepository

class CarReviewerAplication : Application() {


    // HACER EL REPOSITORIO GLOBAL

    val carRepository: CarRepository by lazy {
        CarRepository(carList)
    }
}