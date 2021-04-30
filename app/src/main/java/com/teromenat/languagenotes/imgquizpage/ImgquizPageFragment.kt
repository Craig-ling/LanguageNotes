package com.teromenat.languagenotes.imgquizpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.teromenat.languagenotes.R
import com.teromenat.languagenotes.databinding.FragmentImgquizPageBinding
import com.teromenat.languagenotes.languages.French
import com.teromenat.languagenotes.languages.German

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
        binding.lifecycleOwner = viewLifecycleOwner

        setImage(binding.quizImage, imgquizViewModel.imgWord.value)

        binding.imgSubmitButton.setOnClickListener { view: View ->
            val radioID = binding.imgRadioGroup.checkedRadioButtonId
            var selectedWord = ""
            if (-1 != radioID) {
                imgquizViewModel.incrementAnswered()

                when(radioID) {
                    binding.imgButton1.id -> selectedWord = binding.imgButton1.text.toString()
                    binding.imgButton2.id -> selectedWord = binding.imgButton2.text.toString()
                    binding.imgButton3.id -> selectedWord = binding.imgButton3.text.toString()
                    binding.imgButton4.id -> selectedWord = binding.imgButton4.text.toString()
                }

                if(selectedWord == imgquizViewModel.getWordMapValue()) {
                    imgquizViewModel.incrementCorrect()
                }
                if(imgquizViewModel.questionsAnswered >= imgquizViewModel.totalQuestions.value!!) {
                    view.findNavController().navigate(ImgquizPageFragmentDirections
                            .actionImgquizPageFragmentToImgquizOverPageFragment(imgquizViewModel.correctCount.value!!))
                }
                else {
                    imgquizViewModel.setupQuiz()
                    setImage(binding.quizImage, imgquizViewModel.imgWord.value)
                    binding.imgRadioGroup.clearCheck()
                }
            }
        }

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