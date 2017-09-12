package com.raqun.dctracker.data

/**
 * Created by tyln on 12/09/2017.
 */
interface DataBean<T> {
    fun getData(): T?

    fun getState(): DataState

    fun hasError(): Boolean

    fun getError(): Error?
}