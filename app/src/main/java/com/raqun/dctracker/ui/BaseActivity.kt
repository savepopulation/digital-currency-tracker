package com.raqun.dctracker.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.MenuRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.raqun.dctracker.Constants
import com.raqun.dctracker.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by tyln on 12/09/2017.
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    protected val NAV_TYPE_BACK = 0;
    protected val NAV_TYPE_ROOT = 1;

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @LayoutRes abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())

        // TODO improve this impl
        when (getNavigationType()) {
            NAV_TYPE_BACK -> supportActionBar?.setDisplayHomeAsUpEnabled(true)
            NAV_TYPE_ROOT -> supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

        supportActionBar?.title = getString(getScreenTitle())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (getMenuRes() != Constants.NO_RES) {
            menuInflater.inflate(getMenuRes(), menu)
            return true
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    @StringRes protected open fun getScreenTitle() = R.string.app_name

    @MenuRes protected open fun getMenuRes(): Int = Constants.NO_RES

    protected open fun getNavigationType(): Int = NAV_TYPE_BACK

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}