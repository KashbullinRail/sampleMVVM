package com.example.samplemvvm

import android.app.Application

class App: Application() {


    val models = listOf<Any?>(
        InMemoryColorsRepository()
    )

}