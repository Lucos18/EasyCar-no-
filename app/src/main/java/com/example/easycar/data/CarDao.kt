package com.example.easycar.data

import androidx.room.*
import com.example.easycar.model.Car
import kotlinx.coroutines.flow.Flow

interface CarDao {
    @Query("SELECT * FROM Car")
    fun getForageables(): Flow<List<Car>>

    @Query("SELECT * FROM Car WHERE licencePlate = :licencePlate")
    fun getForageable(licencePlate: Long): Flow<Car>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(Car: Car)

    @Update
    fun update(Car: Car)

    @Delete
    suspend fun delete(Car: Car)
}