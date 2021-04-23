package com.example.languagenotes.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)

        navigateToLanguagePageListener(binding.germanButton, 0)
        navigateToLanguagePageListener(binding.frenchButton, 1)

        return binding.root
    }

    private fun navigateToLanguagePageListener(langButton: Button, langValue: Int) {
        langButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(MainFragmentDirections
                    .actionMainFragmentToLanguagePageFragment(langValue))
        }
    }

}