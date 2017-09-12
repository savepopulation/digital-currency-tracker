package com.raqun.dctracker.di

import com.raqun.dctracker.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tyln on 12/09/2017.
 */
@Module
internal abstract class FragmentBuildersModule {
    @ContributesAndroidInjector @FragmentScope abstract fun contributeHomeFragment(): HomeFragment
}