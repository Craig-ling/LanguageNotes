package com.teromenat.languagenotes.languagepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.teromenat.languagenotes.R
import com.teromenat.languagenotes.databinding.FragmentLanguagePageBinding

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

        binding.comsenButton.setOnClickListener{ view ->
            view.findNavController().navigate(LanguagePageFragmentDirections.
            actionLanguagePageFragmentToCommonSentencesPageFragment(langNum))
        }

        return binding.root
    }

}