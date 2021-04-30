package com.teromenat.languagenotes.commonsentencespage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teromenat.languagenotes.R
import com.teromenat.languagenotes.databinding.CommonSentenceItemBinding
import com.teromenat.languagenotes.domain.CommonSentence

class CommonSentenceAdapter : RecyclerView.Adapter<CommonSentenceAdapter.CommonSentenceViewHolder>() {

    var sentences: List<CommonSentence> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return sentences.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonSentenceViewHolder {
        val dataBinding: CommonSentenceItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                CommonSentenceViewHolder.LAYOUT,
                parent,
                false)
        return CommonSentenceViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: CommonSentenceViewHolder, position: Int) {
        holder.binding.also {
            it.commonSentence = sentences[position]
        }
    }

    class CommonSentenceViewHolder(val binding: CommonSentenceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            companion object {
                @LayoutRes
                val LAYOUT = R.layout.common_sentence_item
            }
    }
}
