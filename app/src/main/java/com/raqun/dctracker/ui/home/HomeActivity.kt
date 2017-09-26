package com.raqun.dctracker.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import com.raqun.dctracker.R
import com.raqun.dctracker.ext.init
import com.raqun.dctracker.ui.BaseActivity

/**
 * Created by tyln on 12/09/2017.
 */
class HomeActivity : BaseActivity() {

    @LayoutRes override fun getLayoutRes(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init(savedInstanceState, HomeFragment.newInstance())
    }

    override fun getNavigationType(): Int = NAV_TYPE_ROOT

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}