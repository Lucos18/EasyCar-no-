package com.example.easycar

import android.app.Application
import com.example.easycar.data.CarDatabase

class BaseApplication : Application() {

    // TODO: provide a ForageDatabase value by lazy here
    val database: CarDatabase by lazy { CarDatabase.getDatabase(this) }
}