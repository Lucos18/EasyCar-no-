package com.example.easycar.ui.viewmodel

import androidx.lifecycle.*
import com.example.easycar.data.CarDao
import com.example.easycar.model.Car
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.Files.delete

class CarViewModel(
    private val CarDao: CarDao
) : ViewModel(){
    val allCars: LiveData<List<Car>> = CarDao.getCars().asLiveData()

    fun getCarById(id: Long): LiveData<Car> {
        return CarDao.getCarById(id).asLiveData()
    }
    //TODO add Function to add new car if needed

    //TODO add Function to update new car if needed

    fun deleteCar(car: Car) {
        viewModelScope.launch(Dispatchers.IO) {
            CarDao.delete(car)
        }
    }
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