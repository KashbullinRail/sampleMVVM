package com.example.samplemvvm

import android.app.Application
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

const val ARG_SCREEN = "ARG_SCREEN"

class MainViewModel(application: Application) : AndroidViewModel(application), Navigator,
    UiActions {

    val whenActivityActive = ResourceActions<MainActivity>()

    private val _result = MutableLiveEvent<Any>()
    val result: LiveEvent<Any> = _result

    override fun launch(screen:BaseScreen) = whenActivityActive {
        launchFragment(it, screen)
    }

    override fun goBack(result: Any?) = whenActivityActive {
        if (result != null){
            _result.value = Event(result)
        }
        it.onBackPressed
    }

    override fun toast(massege: String) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
    }

    override fun getString(messageRes: Int, vararg args: Any): String {
        return getApplication<App>().getString(messageRes, *args)
    }

    fun launchFragment(activity: MainActivity, screen: BaseScreen, addToBackStack: Boolean = true){
        val fragment = screen.javaClass.enclosingClass.newIntance() as Fragment
        fragment.arguments = bundleOf(ARG_SCREEN to screen)
    }


}


