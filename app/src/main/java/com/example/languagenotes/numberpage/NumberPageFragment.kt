package com.example.languagenotes.numberpage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentNumberPageBinding
import com.example.languagenotes.languages.French
import com.example.languagenotes.languages.German

class NumberPageFragment : Fragment() {

    private lateinit var binding: FragmentNumberPageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_number_page, container, false)

        val arguments = NumberPageFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory: NumberPageViewModelFactory = when(arguments.languageKey) {
            0 -> NumberPageViewModelFactory(German())
            1 -> NumberPageViewModelFactory(French())
            else -> throw Exception("Error, language integer not found")
        }

        val numberPageViewModel = ViewModelProvider(this, viewModelFactory)
                .get(NumberPageViewModel::class.java)

        binding.numberPageViewModel = numberPageViewModel

        // Observes changes of LiveData in the ViewModel
        binding.lifecycleOwner = this

        numberPageViewModel.hideNumberText()

        // TODO: Clean this up (modularize)
        numberPageViewModel.genNumberBegin.observe(viewLifecycleOwner, Observer { itBool ->
            if (itBool) {
                val numList = numberPageViewModel.generateNumbers()
                val dig1 = numList[0]
                val dig2 = numList[1]
                setDigitImage(dig1, binding.firstDigit)
                setDigitImage(dig2, binding.secondDigit)
                var genNumber = ""
                genNumber = if (dig1 != 0) {
                    "$dig1$dig2"
                } else {
                    "$dig2"
                }
                numberPageViewModel.setNumberText(genNumber.toInt())
                numberPageViewModel.endGenerateNumber()
            }
        })

        return binding.root
    }

    private fun setDigitImage(num: Int, imgView: ImageView) {
        when(num) {
            0 -> imgView.setImageResource(R.drawable.zero)
            1 -> imgView.setImageResource(R.drawable.one)
            2 -> imgView.setImageResource(R.drawable.two)
            3 -> imgView.setImageResource(R.drawable.three)
            4 -> imgView.setImageResource(R.drawable.four)
            5 -> imgView.setImageResource(R.drawable.five)
            6 -> imgView.setImageResource(R.drawable.six)
            7 -> imgView.setImageResource(R.drawable.seven)
            8 -> imgView.setImageResource(R.drawable.eight)
            9 -> imgView.setImageResource(R.drawable.nine)
        }
    }

}