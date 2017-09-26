package com.raqun.dctracker.ext

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by tyln on 26/09/2017.
 */
inline fun FragmentManager.navigate(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun FragmentManager.openFragment(@IdRes flId: Int, fragment: Fragment) {
    beginTransaction()
            .replace(flId, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
}