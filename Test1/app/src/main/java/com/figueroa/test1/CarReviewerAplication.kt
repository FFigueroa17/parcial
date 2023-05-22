package com.figueroa.test1

import android.app.Application
import com.figueroa.test1.data.carList
import com.figueroa.test1.repositories.CarRepository

// TODO 1: Create a class that extends from Application

class CarReviewerAplication: Application() {

    // TODO 2: Create a val carRepository that returns a CarRepository instance with the carList as a parameter.

    val carRepository: CarRepository by lazy {
        CarRepository(carList)
    }

}