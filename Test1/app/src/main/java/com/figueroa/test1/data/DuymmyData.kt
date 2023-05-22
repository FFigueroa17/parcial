package com.figueroa.test1.data

import com.figueroa.test1.data.models.CarModel

// CAR DUMMY DATA

// TODO 1: Create "x" cars with the following data

// CAR 1

val name1 = "Audi"
val model1 = "A4"
val year1 = 2019
val description = "El Audi es una marca de automóviles reconocida mundialmente por su sofisticación, elegancia y rendimiento excepcional. Con un diseño vanguardista y líneas aerodinámicas, los vehículos de Audi cautivan a los amantes de la conducción y la calidad."
val price1 = 100000

// CAR 2

val name2 = "BMW"
val model2 = "X5"
val year2 = 2018
val description2 = "BMW es una marca de automóviles alemana reconocida mundialmente por su sofisticación, elegancia y rendimiento excepcional. Con un diseño vanguardista y líneas aerodinámicas, los vehículos de BMW cautivan a los amantes de la conducción y la calidad."
val price2 = 200000

// TODO 2: Create a list of cars with the previous data

var carList = mutableListOf(

    // TODO 3: Add the cars to the list of cars using the CarModel class

    CarModel(name1, model1, year1, description, price1),
    CarModel(name2, model2, year2, description2, price2)
)