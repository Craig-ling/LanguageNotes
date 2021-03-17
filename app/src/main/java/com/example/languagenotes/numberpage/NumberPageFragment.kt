package com.example.languagenotes.numberpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentNumberPageBinding

class NumberPageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: FragmentNumberPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_number_page, container, false)

        return binding.root
    }
}