package com.example.languagenotes.languagepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentLanguagePageBinding

class LanguagePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: FragmentLanguagePageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_language_page, container, false)

        val arguments = LanguagePageFragmentArgs.fromBundle(requireArguments())
        val langNum = arguments.languageKey

        binding.numbersButton.setOnClickListener {  view : View ->
            view.findNavController().navigate(LanguagePageFragmentDirections
                    .actionLanguagePageFragmentToNumberPageFragment(langNum))
        }

        binding.imgquizButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(LanguagePageFragmentDirections.
            actionLanguagePageFragmentToImgquizPageFragment(langNum))
        }

        return binding.root
    }
}