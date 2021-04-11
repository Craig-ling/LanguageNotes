package com.example.languagenotes.imgquizpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentImgquizoverPageBinding

class ImgquizOverPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentImgquizoverPageBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_imgquizover_page, container, false)

        val arguments = ImgquizOverPageFragmentArgs.fromBundle(requireArguments())
        val correct = arguments.correctAnswers.toString()

        val gameOverText = getString(R.string.imgquiz_over_text, correct)

        binding.gameOverText.text = gameOverText

        return binding.root
    }
}