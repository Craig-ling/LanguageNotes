package com.teromenat.languagenotes.commonsentencespage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teromenat.languagenotes.R
import com.teromenat.languagenotes.databinding.FragmentCommonsentencesPageBinding
import com.teromenat.languagenotes.domain.CommonSentence

class CommonSentencesPageFragment : Fragment() {

    private lateinit var binding: FragmentCommonsentencesPageBinding
    private var recyclerAdapter: CommonSentenceAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_commonsentences_page,
                container, false)

        // Set the lifecycleOwner so DataBinding can observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner

        val activity = requireNotNull(this.activity)
        val arguments = CommonSentencesPageFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory = CommonSentencesPageViewModelFactory(
                activity.application, arguments.languageKey)

        val viewModel = ViewModelProvider(this, viewModelFactory)
                .get(CommonSentencesPageViewModel::class.java)

        recyclerAdapter = CommonSentenceAdapter()

        binding.root.findViewById<RecyclerView>(R.id.sen_recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }

        viewModel.comSenList.observe(viewLifecycleOwner, Observer<List<CommonSentence>> { sentence ->
            sentence?.apply {
                recyclerAdapter?.sentences = sentence
            }
        })

        return binding.root
    }
}