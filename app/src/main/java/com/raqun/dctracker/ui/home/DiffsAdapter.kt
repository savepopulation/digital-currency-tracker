package com.raqun.dctracker.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.raqun.dctracker.databinding.ItemDiffBinding
import com.raqun.dctracker.model.Diff

/**
 * Created by tyln on 12/09/2017.
 */
class DiffsAdapter(private val products: List<Diff>) : RecyclerView.Adapter<DiffsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return ViewHolder(ItemDiffBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            val product = products[position]
            it.bind(product)
        }
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(private val itemBinding: ItemDiffBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(diff: Diff) {
            itemBinding.diff = diff
            itemBinding.executePendingBindings()
        }
    }
}