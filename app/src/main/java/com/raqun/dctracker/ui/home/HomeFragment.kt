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
import com.raqun.dctracker.ext.setup
import com.raqun.dctracker.model.Diff
import com.raqun.dctracker.model.UiDataBean
import com.raqun.dctracker.ui.BinderFragment

/**
 * Created by tyln on 12/09/2017.
 */

class HomeFragment : BinderFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getModelClass() = HomeViewModel::class.java

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getDiffsLiveData().observe(this, Observer {
            bean: DataBean<List<Diff>>? ->
            bean?.let {
                binding.diffBean = bean
            }
        })
    }

    override fun initView() {
        binding.diffs.setup(activity)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}