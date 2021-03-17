package com.example.languagenotes.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = viewModel

        // Set lifecycle owner to observe LiveData in the view model.
        binding.lifecycleOwner = this

        binding.germanButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(MainFragmentDirections
                .actionMainFragmentToLanguagePageFragment(0))
        }

        return binding.root
    }

}