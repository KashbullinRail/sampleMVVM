package com.example.samplemvvm.view

import com.example.samplemvvm.view.base.BaseScreen

interface Navigator {

    fun launch(screen: BaseScreen)

    fun goBack(result: Any? = null)

}