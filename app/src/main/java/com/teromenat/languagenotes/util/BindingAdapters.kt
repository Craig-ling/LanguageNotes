package com.teromenat.languagenotes.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.teromenat.languagenotes.numberpage.setDigitImage

@BindingAdapter("firstDigitImage")
fun bindFirstDigitImage(imgView: ImageView, digit: Int) {
    setDigitImage(imgView, digit)
}

@BindingAdapter("secondDigitImage")
fun bindSecondDigitImage(imgView: ImageView, digit: Int) {
    setDigitImage(imgView, digit)
}