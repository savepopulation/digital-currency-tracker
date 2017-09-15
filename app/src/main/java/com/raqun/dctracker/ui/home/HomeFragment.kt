package com.raqun.dctracker.ui.home

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.raqun.dctracker.R
import com.raqun.dctracker.data.DataBean
import com.raqun.dctracker.databinding.FragmentHomeBinding
import com.raqun.dctracker.model.Diff
import com.raqun.dctracker.model.UiDataBean
import com.raqun.dctracker.ui.BinderFragment

/**
 * Created by tyln on 12/09/2017.
 */

fun RecyclerView.setup(context: Context) {
    val layoutManager = LinearLayoutManager(context)
    layoutManager.orientation = LinearLayoutManager.HORIZONTAL
    this.layoutManager = layoutManager
    this.setHasFixedSize(true)
}

class HomeFragment : BinderFragment<FragmentHomeBinding, HomeViewModel>() {

    private var recyclerViewDiff: RecyclerView? = null

    override fun getModelClass() = HomeViewModel::class.java

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewDiff = view?.findViewById<RecyclerView>(R.id.diffs)?.apply {
            setup(context)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getDiffsLiveData().observe(this, Observer {
            bean: DataBean<List<Diff>>? ->
            bean?.let {
                binding.diffBean = bean
            }
        })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}