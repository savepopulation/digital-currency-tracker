package com.raqun.dctracker.di

import com.raqun.dctracker.DcTrackerApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by tyln on 12/09/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        ActivityModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DcTrackerApp): Builder

        fun build(): AppComponent
    }

    fun inject(application: DcTrackerApp)
}