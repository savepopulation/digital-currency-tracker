package com.raqun.dctracker.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.view.View
import com.raqun.dctracker.ui.home.HomeViewModel
import com.raqun.dctracker.viewmodel.VMFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by tyln on 12/09/2017.
 */
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    // Factory
    @Binds abstract fun bindViewModelFactory(vmFactory: VMFactory): ViewModelProvider.Factory
}