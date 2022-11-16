package com.example.easycar.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Car")
data class Car(
    @PrimaryKey val licencePlate: String,
    @ColumnInfo val brand: String,
    @ColumnInfo val model: String,
    @ColumnInfo (name="year_start_production") val yearStartProduction: Int,
    @ColumnInfo (name="year_end_production") val yearEndProduction: Int,
    @ColumnInfo val seats: Int,
    @ColumnInfo (name="fuel_type") val fuelType: String
)
