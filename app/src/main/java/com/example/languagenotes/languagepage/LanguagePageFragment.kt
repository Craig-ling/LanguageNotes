package com.example.languagenotes.languagepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentLanguagePageBinding

class LanguagePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: FragmentLanguagePageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_language_page, container, false)

        binding.numbersButton.setOnClickListener {  view : View ->
            view.findNavController().navigate(R.id.action_languagePageFragment_to_numberPageFragment)
        }

        return binding.root
    }
}