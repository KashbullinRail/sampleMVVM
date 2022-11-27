package com.example.samplemvvm.view.changecolor

import com.example.samplemvvm.model.colors.NamedColor

data class NamedColorListItem(
    val namedColor: NamedColor,
    val selected: Boolean
)