package com.example.languagenotes.germanpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.languagenotes.R
import com.example.languagenotes.databinding.GermanFragmentBinding
import com.example.languagenotes.databinding.GermanNumbersFragmentBinding

class GermanNumbersFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: GermanNumbersFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.german_numbers_fragment, container, false)

        return binding.root
    }
}
