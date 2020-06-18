package com.waldener.musicdog.ui.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.waldener.musicdog.R
import com.waldener.musicdog.room.entity.Record
import kotlinx.android.synthetic.main.fragment_recent.*

class RecentFragment : Fragment() {

    private val viewModel: RecentVM by lazy {
        ViewModelProvider(this).get(RecentVM::class.java)
    }

    private val adapter = RecentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter

        viewModel.getRecordLiveData()?.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })

        fab.setOnClickListener {
            viewModel.insert(Record("xxx"))
        }

    }
}