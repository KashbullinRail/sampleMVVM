package com.example.samplemvvm

import android.app.Application
import com.example.samplemvvm.model.colors.InMemoryColorsRepository

class App: Application() {


    val models = listOf<Any?>(
        InMemoryColorsRepository()
    )

}