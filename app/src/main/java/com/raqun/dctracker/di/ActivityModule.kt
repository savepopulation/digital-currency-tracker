package com.raqun.dctracker.di

import com.raqun.dctracker.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tyln on 12/09/2017.
 */
@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    @ActivityScope
    abstract fun provideHomeActivityContributor(): HomeActivity
}