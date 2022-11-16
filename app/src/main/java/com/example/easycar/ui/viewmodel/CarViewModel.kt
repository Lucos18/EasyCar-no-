package com.example.easycar.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.easycar.data.CarDao
import com.example.easycar.model.Car

class CarViewModel(
    private val CarDao: CarDao
) : ViewModel(){
    val allCars: LiveData<List<Car>> = CarDao.getForageables().asLiveData()

}
class CarViewModelFactory(private val CarDao: CarDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarViewModelFactory::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CarViewModelFactory(CarDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}