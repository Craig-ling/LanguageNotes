package com.example.languagenotes.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentMainBinding

class MainFragment : Fragment() {

//    companion object {
//        fun newInstance() = MainFragment()
//    }

//    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)

        binding.germanButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_languagePageFragment)
        }

        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}