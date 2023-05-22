package com.figueroa.test1.ui.car.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.figueroa.test1.CarReviewerAplication
import com.figueroa.test1.data.models.CarModel
import com.figueroa.test1.repositories.CarRepository

// TODO 1: Create a ViewModel class called CarViewModel that receives a CarRepository as a parameter

class CarViewModel(private val carRepository: CarRepository): ViewModel() {

    // TODO 2: Create a MutableLiveData for each of the attributes of the CarModel class

    var name = MutableLiveData("")
    var brand = MutableLiveData("")
    var year = MutableLiveData("")
    var description = MutableLiveData("")
    var price = MutableLiveData("")

    // AGREGAMOS EL STAUTS, QUE NOS AYUDARA A VALIDAR EL ESTADO DE LA DATA

    var status = MutableLiveData("")

    // TODO 3: Create a function called getCars that returns the list of cars from the repository

    fun getCars() = carRepository.getCars()

    // TODO 4: Create a function called addCar that receives a CarModel as a parameter and adds it to the repository

    private fun addCar(car: CarModel) = carRepository.addCar(car)

    // TODO 5: Create a function called createCar that validates the data and adds a new car to the repository

    private fun createCar(){

        // VALIDAMOS QUE LA DATA NO ESTE VACIA

        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        //SI TO DO ESTA BIEN, CREAMOS EL CARRO

        val car = CarModel(
            name.value!!,
            brand.value!!,
            year.value!!.toInt(),
            description.value!!,
            price.value!!.toInt()
        )

        // AGREGAMOS EL CARRO AL REPOSITORIO

        addCar(car)

        // LIMPIAMOS LA DATA

        clearData()

        // CAMBIAMOS EL STATUS

        status.value = CAR_CREATED
    }
    // FUNCION PARA VALIDAR LA DATA

    private fun validateData(): Boolean{
        when {
            // CUANDO LOS CAMPOS SEAN NULL OR EMPTY, RETORNAR FALSO
            name.value.isNullOrEmpty() -> return false
            brand.value.isNullOrEmpty() -> return false
            year.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            price.value.isNullOrEmpty() -> return false
        }

        // DE LO CONTRARIO, RETORNAR VERDADERO ( TODO ESTA BIEN )
        return true
    }

    // FUNCION PARA LIMPIAR LA DATA

    fun clearData(){

        // LIMPIAMOS TODOS LOS DATOS

        name.value = ""
        brand.value = ""
        year.value = ""
        description.value = ""
        price.value = ""
    }

    // FUNCION PARA LIMPIAR EL STATUS

    fun clearStatus() {
        status.value = INACTIVE
    }

    // SET SELECTED DATA

    fun setSelectedCar(car: CarModel) {
        name.value = car.name
        brand.value = car.brand
        year.value = car.year.toString()
        description.value = car.description
        price.value = car.price.toString()
    }

    // AGREGAMOS EL FACTORY, QUE NOS AYUDARA A CREAR EL VIEW MODEL

    // TODO : Add a companion object to the class, to create the factory of the view model

    companion object{

        // TODO 6: Create a factory, for the view model, that receives a CarRepository as a parameter and returns a CarViewModel instance

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CarReviewerAplication
                CarViewModel(app.carRepository)
            }
        }

        // TODO 7: Create a const val for each of the possible status of the app that will help us later on the UI

        const val CAR_CREATED = "Car created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = "Inactive"

    }
}