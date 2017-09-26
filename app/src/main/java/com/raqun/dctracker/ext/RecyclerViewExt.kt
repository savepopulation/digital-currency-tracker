package com.raqun.dctracker.ext

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by tyln on 26/09/2017.
 */
fun RecyclerView.setup(context: Context) {
    val layoutManager = LinearLayoutManager(context)
    layoutManager.orientation = LinearLayoutManager.HORIZONTAL
    this.layoutManager = layoutManager
    this.setHasFixedSize(true)
}