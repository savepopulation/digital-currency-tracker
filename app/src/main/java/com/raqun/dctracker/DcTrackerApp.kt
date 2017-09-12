package com.raqun.dctracker

import android.app.Activity
import android.app.Application
import com.raqun.dctracker.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by tyln on 12/09/2017.
 */
class DcTrackerApp : Application(), HasActivityInjector {

    @Inject lateinit var dispachingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector() = dispachingAndroidInjector
}