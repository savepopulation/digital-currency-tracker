package com.raqun.dctracker.data.source

import com.raqun.dctracker.model.Diff
import io.reactivex.Single

/**
 * Created by tyln on 12/09/2017.
 */
interface DiffDataSource {
    fun getDiffs(): Single<List<Diff>>
}