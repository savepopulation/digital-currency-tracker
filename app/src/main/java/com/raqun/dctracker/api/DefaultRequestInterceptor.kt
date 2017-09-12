package com.raqun.dctracker.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by tyln on 12/09/2017.
 */
class DefaultRequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        chain?.let {
            return chain.proceed(with(chain.request().newBuilder()) {
                addHeader("Content-Type", "application/json")
                // Some other headers...
                build()
            })
        }

        return null
    }
}