package com.raqun.dctracker.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

/**
 * Created by tyln on 12/09/2017.
 */
abstract class BinderFragment<VB : ViewDataBinding, VM : ViewModel> : BaseFragment() {

    @Inject protected lateinit var vmFactory: ViewModelProvider.Factory
    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    // TODO improve this impl
    abstract fun getModelClass(): Class<VM>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        initView()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, vmFactory).get(getModelClass())
    }

    open protected fun initView() {
        // Can be overridden from subclasses
    }
}