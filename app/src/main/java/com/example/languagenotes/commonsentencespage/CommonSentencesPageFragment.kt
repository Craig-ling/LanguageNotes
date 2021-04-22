package com.example.languagenotes.commonsentencespage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentCommonsentencesPageBinding

class CommonSentencesPageFragment : Fragment() {

    private lateinit var binding: FragmentCommonsentencesPageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_commonsentences_page,
                container, false)

        val arguments = CommonSentencesPageFragmentArgs.fromBundle(requireArguments())

        return binding.root
    }
}