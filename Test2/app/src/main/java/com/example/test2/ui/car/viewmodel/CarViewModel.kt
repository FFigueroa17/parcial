package com.example.test2.ui.car.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.test2.CarReviewerAplication
import com.example.test2.data.model.CarModel
import com.example.test2.repository.CarRepository

class CarViewModel(private val repository: CarRepository) : ViewModel() {

    // DATA

    var name = MutableLiveData("")
    var brand = MutableLiveData("")
    var description =  MutableLiveData("")

    // STATUS

    var statu = MutableLiveData("")


    // AGREGAR LAS FUNCIONES

    // GET CARS

    fun getCars() = repository.getCars()

    private fun addCar(car:CarModel) = repository.addCars(car)

    fun createCar() {

        // VALIDAR LA DATA

        if (!validateData()){
            // SI LA DATA ESTA MALA
            statu.value = WRONG_INFORMATION
            return
        }

        // SI TO DO ESTA BIEN CREAMOS EL CARRO

        val car = CarModel(
            name.value!!,
            brand.value!!,
            description.value!!
        )

        // AGREGAMOS EL CARRO

        addCar(car)

        // LIMPIAMOS LA DATA

        clearData()

        // ACUATILIZAMOS EL STATUS

        statu.value =  CAR_CREATED

    }

    // FUNCION PARA LIMPIAR LA DATA

    fun clearData() {
        name.value = ""
        brand.value = ""
        description.value = ""
    }

    // FUNCION PARA VALIDAR LA DATA

    private fun validateData() : Boolean{
        // CUANDO ...
        when{
            name.value.isNullOrEmpty() -> return false
            brand.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
        }

        return true
    }

    // FUNCION PARA LIMPIAR EL STATUS

    fun clearStatus(){
        statu.value = INACTIVE
    }

    // SET SELECTED CAR

    fun setSelectedCar(car: CarModel){

        name.value = car.name
        brand.value = car.brand
        description.value = car.description

    }

    // CREAR LA FACTORY

    companion object{


        // FACTORY

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CarReviewerAplication
                CarViewModel(app.carRepository)
            }
        }

        // CREAR ESTADOS

        const val CAR_CREATED = "Car created"
        const val WRONG_INFORMATION = "wrong information"
        const val INACTIVE = "inactive"

    }
}