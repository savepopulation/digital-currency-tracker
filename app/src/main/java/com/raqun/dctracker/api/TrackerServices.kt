package com.raqun.dctracker.api

import com.raqun.dctracker.model.DefaultResponse
import com.raqun.dctracker.model.Diff
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by tyln on 12/09/2017.
 */
interface TrackerServices {
    @GET("money")
    fun getDiffs(): Single<List<Diff>>
}