package com.raqun.dctracker.di

import com.raqun.dctracker.DcTrackerApp
import com.raqun.dctracker.api.TrackerServices
import com.raqun.dctracker.data.source.remote.DiffRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tyln on 12/09/2017.
 */
@Module(includes = arrayOf(ViewModelModule::class))
internal class AppModule {

    @Provides @Singleton fun provideApplicationContext(app: DcTrackerApp)
            = app.applicationContext

    @Provides @Singleton fun provideProductRemoteDataSource(trackerServices: TrackerServices): DiffRemoteDataSource
            = DiffRemoteDataSource(trackerServices)
}