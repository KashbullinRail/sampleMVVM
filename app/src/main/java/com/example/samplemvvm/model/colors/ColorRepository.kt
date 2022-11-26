package com.example.samplemvvm.model.colors

import com.example.samplemvvm.model.Repository

typealias ColorListener = (NamedColor) -> Unit

interface ColorRepository : Repository {

    var currentColor: NamedColor

    fun getAvailableColors(): List<NamedColor>

    fun getById(id: Long): NamedColor

    fun addListener(listener: ColorListener)

    fun removeListener(listener: ColorListener)

}