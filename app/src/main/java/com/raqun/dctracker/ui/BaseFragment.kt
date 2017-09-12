package com.raqun.dctracker.ui

import android.app.Application
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.MenuRes
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import com.raqun.dctracker.Constants
import com.raqun.dctracker.R
import com.raqun.dctracker.api.ApiConstants
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import com.raqun.dctracker.data.Error

/**
 * Created by tyln on 12/09/2017.
 */
abstract class BaseFragment : Fragment(), BaseView, LifecycleRegistryOwner {

    protected val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)
    protected var navigationController: NavigationController? = null

    @LayoutRes protected abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        if (activity is HasSupportFragmentInjector) {
            AndroidSupportInjection.inject(this)
        }
        super.onCreate(savedInstanceState)
        navigationController = NavigationController(activity)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        if (getMenuRes() != Constants.NO_RES) {
            inflater?.inflate(getMenuRes(), menu)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getLayoutRes(), null, false)
    }

    override fun onDestroyView() {
        navigationController = null
        super.onDestroyView()
    }

    override fun onError(e: Error?) {
        e?.let {
            when (e.code) {
                ApiConstants.ERROR_CODE_AUTH -> navigationController?.close()
                else -> defaultErrorBehavior(e)
            }
        } ?: defaultErrorBehavior(e)
    }

    private fun defaultErrorBehavior(e: Error?) {
        val message: String
        if (e != null && !TextUtils.isEmpty(e.message)) message = e.message else message = getString(R.string.error_message_unknown)
        alert(message)
    }

    protected fun alert(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun getLifecycle(): LifecycleRegistry = lifecycleRegistry

    @MenuRes protected open fun getMenuRes(): Int = Constants.NO_RES

    fun getApplication(): Application = activity.application

    fun getApplicationContext(): Context = getApplication().applicationContext
}