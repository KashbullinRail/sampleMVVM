package com.example.samplemvvm.view

interface UiActions {

    fun toast(massege: String)

    fun getString(messageRes: Int, vararg args:Any): String

}