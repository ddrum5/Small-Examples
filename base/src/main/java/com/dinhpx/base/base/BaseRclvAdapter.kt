package com.dinhpx.base.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRclvAdapter : RecyclerView.Adapter<BaseViewHolder<Any>>() {

    open val mDataSets = mutableListOf<Any>()

    abstract val mapVH: Map<Int, BaseViewHolder<Any>>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return mapVH[viewType]!!
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        holder.onBind(mDataSets[position])
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<Any>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.onBindPayLoad(mDataSets[position], payloads)
    }


    override fun getItemCount(): Int {
        return mDataSets.size
    }
}