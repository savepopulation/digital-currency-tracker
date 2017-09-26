package com.raqun.dctracker.ext

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.raqun.dctracker.R

/**
 * Created by tyln on 26/09/2017.
 */
fun AppCompatActivity.init(savedInstanceState: Bundle?, fragment: Fragment) {
    if (savedInstanceState == null) {
        this.supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelayout_main, fragment)
                .commit()
    }
}