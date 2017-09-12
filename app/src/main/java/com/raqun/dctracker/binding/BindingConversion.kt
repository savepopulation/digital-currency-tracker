package com.raqun.dctracker.binding

import android.view.View
import com.raqun.dctracker.data.DataBean
import com.raqun.dctracker.data.DataState
import android.databinding.BindingConversion

/**
 * Created by tyln on 12/09/2017.
 */
object BindingConversion {

    @JvmStatic
    @BindingConversion
    fun <T> bindBeanToProgress(bean: DataBean<T>?): Int
            = if (bean?.getState() == DataState.FETCHING && bean.getData() == null) View.VISIBLE else View.GONE

    @JvmStatic
    @BindingConversion
    fun bindBooleanToVisiblity(isVisible: Boolean): Int
            = if (isVisible) View.VISIBLE else View.GONE

}