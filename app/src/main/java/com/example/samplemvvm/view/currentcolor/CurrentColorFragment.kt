package com.example.samplemvvm.view.currentcolor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.samplemvvm.R
import com.example.samplemvvm.databinding.FragmentCurrentColorBinding
import com.example.samplemvvm.view.base.BaseFragment
import com.example.samplemvvm.view.base.BaseScreen
import com.example.samplemvvm.view.base.screenViewModel

class CurrentColorFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<CurrentColorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCurrentColorBinding.inflate(inflater, container, false)

        viewModel.currentColor.observe(viewLifecycleOwner) {
            binding.colorView.setBackgroundColor(it.value)
        }

        binding.changeColorButton.setOnClickListener {
            viewModel.changeColor()
        }
        return binding.root

    }

}