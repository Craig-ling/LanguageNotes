package com.example.languagenotes.imgquizpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.languagenotes.R
import com.example.languagenotes.databinding.FragmentImgquizPageBinding
import com.example.languagenotes.languages.French
import com.example.languagenotes.languages.German

class ImgquizPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentImgquizPageBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_imgquiz_page, container, false)

        val arguments = ImgquizPageFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory: ImgquizPageViewModelFactory = when (arguments.languageKey) {
            0 -> ImgquizPageViewModelFactory(German())
            1 -> ImgquizPageViewModelFactory(French())
            else -> throw Exception("Error, invalid language key in ImgquizPageFragment")
        }

        val imgquizViewModel = ViewModelProvider(this, viewModelFactory)
                .get(ImgquizPageViewModel::class.java)

        binding.imgquizViewModel = imgquizViewModel

        // Observes changes of LiveData in the ViewModel
        binding.lifecycleOwner = this

        setImage(binding.quizImage, imgquizViewModel.imgWord.value)



        return binding.root
    }

    private fun setImage(imgView: ImageView, word: String?) {
        when(word) {
            "Book" -> imgView.setImageResource(R.drawable.book)
            "Cat" -> imgView.setImageResource(R.drawable.cat)
            "Chair" -> imgView.setImageResource(R.drawable.chair)
            "Dog" -> imgView.setImageResource(R.drawable.dog)
            "Fire" -> imgView.setImageResource(R.drawable.fire)
            "Phone" -> imgView.setImageResource(R.drawable.phone)
            "Sun" -> imgView.setImageResource(R.drawable.sun)
            "Ticket" -> imgView.setImageResource(R.drawable.ticket)
            "Waiter" -> imgView.setImageResource(R.drawable.waiter)
            "Water" -> imgView.setImageResource(R.drawable.water)
            else -> throw Exception("Error, image string not found in Image Quiz Fragment")
        }
    }
}