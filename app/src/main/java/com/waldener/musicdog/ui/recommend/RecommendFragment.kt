package com.waldener.musicdog.ui.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.waldener.musicdog.R
import kotlinx.android.synthetic.main.fragment_recent.*

class RecommendFragment : Fragment() {

    private val viewModel: RecommendVM by lazy {
        ViewModelProvider(this).get(RecommendVM::class.java)
    }

    private val adapter = RecommendAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.recommendLiveData.observe(viewLifecycleOwner, Observer {
            adapter.update(it?.items)
        })

        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter

        fab.setOnClickListener {
            viewModel.getRecommendList()
        }

        viewModel.getRecommendList()

    }
}