package com.example.samplemvvm

interface UiActions {

    fun toast(massege: String)

    fun getString(messageRes: Int, vararg args:Any): String

}