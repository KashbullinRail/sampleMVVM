package com.example.samplemvvm

interface Navigator {

    fun launch(screen:BaseScreen)

    fun goBack(result: Any? = null)

}