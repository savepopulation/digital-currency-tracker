package com.raqun.dctracker.data.source.remote

import com.raqun.dctracker.api.TrackerServices
import com.raqun.dctracker.data.source.DiffDataSource
import com.raqun.dctracker.model.Diff
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by tyln on 12/09/2017.
 */
class DiffRemoteDataSource @Inject constructor(private val trackerServices: TrackerServices)
    : DiffDataSource {

    override fun getDiffs(): Single<List<Diff>> = trackerServices.getDiffs()
}