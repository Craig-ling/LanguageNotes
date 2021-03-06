package com.teromenat.languagenotes.numberpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.teromenat.languagenotes.R
import com.teromenat.languagenotes.databinding.FragmentNumberPageBinding
import com.teromenat.languagenotes.languages.French
import com.teromenat.languagenotes.languages.German

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
            else -> throw Exception("Error, invalid language key in NumberPageFragment")
        }

        val numberPageViewModel = ViewModelProvider(this, viewModelFactory)
                .get(NumberPageViewModel::class.java)

        binding.numberPageViewModel = numberPageViewModel

        // Observes changes of LiveData in the ViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        numberPageViewModel.hideNumberText()

        numberPageViewModel.genNumberBegin.observe(viewLifecycleOwner, Observer { itBool ->
            if (itBool) {
                var genNumber = getStringNumber(numberPageViewModel.generateNumbers(), numberPageViewModel)
                numberPageViewModel.setNumberText(genNumber.toInt())
                numberPageViewModel.endGenerateNumber()
            }
        })

        return binding.root
    }

    private fun getStringNumber(numberList: List<Int>, viewModel: NumberPageViewModel) : String {
        val dig1 = numberList[0]
        val dig2 = numberList[1]

        viewModel.setDigits(dig1, dig2)

        return if (dig1 != 0) {
            "$dig1$dig2"
        } else {
            "$dig2"
        }
    }

}

fun setDigitImage(imgView: ImageView, num: Int) {
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