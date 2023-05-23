package com.example.test2.data

import com.example.test2.data.model.CarModel

val name1 = "Honda civic"
val brand1 = "Honda"
val description1 = "Honda civic 2010, precio: $20000"

val name2 = "Honda Accord"
val brand2 = "Honda"
val description2 = "Honda accord 2010, precio: $20000"

var carList = mutableListOf(

    // CREAMOS LA DUMMY DATA
    CarModel(name1, brand1, description1),
    CarModel(name2, brand2, description2)
)