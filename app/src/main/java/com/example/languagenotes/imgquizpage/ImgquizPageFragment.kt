package com.example.languagenotes.imgquizpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentImgquizPageBinding

class ImgquizPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentImgquizPageBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_imgquiz_page, container, false)



        return binding.root
    }
}