package com.raqun.dctracker.ui
import com.raqun.dctracker.data.Error

/**
 * Created by tyln on 12/09/2017.
 */
interface BaseView {
    fun onError(e: Error?)
}