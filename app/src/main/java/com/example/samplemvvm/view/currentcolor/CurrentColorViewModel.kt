package com.example.samplemvvm.view.currentcolor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.samplemvvm.R
import com.example.samplemvvm.model.colors.ColorListener
import com.example.samplemvvm.model.colors.ColorsRepository
import com.example.samplemvvm.model.colors.NamedColor
import com.example.samplemvvm.view.Navigator
import com.example.samplemvvm.view.UiActions
import com.example.samplemvvm.view.base.BaseViewModel
import com.example.samplemvvm.view.changecolor.ChangeColorFragment

class CurrentColorViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
    private val colorsRepository: ColorsRepository
) : BaseViewModel() {

    private val _currentColor = MutableLiveData<NamedColor>()
    val currentColor: LiveData<NamedColor> = _currentColor

    private val colorListener: ColorListener = {
        _currentColor.postValue(it)
    }

    // --- example of listening results via model layer

    init {
        colorsRepository.addListener(colorListener)
    }

    override fun onCleared() {
        super.onCleared()
        colorsRepository.removeListener(colorListener)
    }

    // --- example of listening results directly from the screen

    override fun onResult(result: Any) {
        super.onResult(result)
        if (result is NamedColor) {
            val message = uiActions.getString(R.string.changed_color, result.name)
            uiActions.toast(message)
        }
    }

    // ---

    fun changeColor() {
        val currentColor = currentColor.value ?: return
        val screen = ChangeColorFragment.Screen(currentColor.id)
        navigator.launch(screen)
    }

}