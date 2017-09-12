package com.raqun.dctracker.ui

import android.app.Activity
import android.content.Intent
import com.raqun.dctracker.ui.home.HomeActivity

/**
 * Created by tyln on 12/09/2017.
 */
class NavigationController(private val activity: Activity) {

    fun close() {
        activity.finish()
    }

    fun navigteToHome() {
        HomeActivity.newIntent(activity).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }.also {
            activity.startActivity(it)
        }
    }
}