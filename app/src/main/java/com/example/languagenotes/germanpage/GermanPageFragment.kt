package com.example.languagenotes.germanpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.languagenotes.R
import com.example.languagenotes.databinding.GermanFragmentBinding

class GermanPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: GermanFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.german_fragment, container, false)

        return binding.root
    }

}