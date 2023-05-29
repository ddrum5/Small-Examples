package com.dinhpx.base.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dinhpx.base.base.extensions.removeRange

abstract class BaseRclvAdapter : RecyclerView.Adapter<BaseViewHolder<Any>>() {

    protected val mDataSet = mutableListOf<Any>()

    abstract fun createVH(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return createVH(LayoutInflater.from(parent.context), parent, viewType) as BaseViewHolder<Any>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        holder.onBind(mDataSet[position])
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<Any>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.onBindPayLoad(mDataSet[position], payloads)
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    fun getListData(): List<Any> {
        return mDataSet
    }

    fun resetData(listData: List<Any>) {
        mDataSet.clear()
        mDataSet.addAll(listData)
        notifyDataSetChanged()
    }

    protected fun addData(data: Any) {
        mDataSet.add(data)
        notifyItemInserted(mDataSet.lastIndex)
    }

    protected fun addData(position: Int, data: Any) {
        mDataSet.add(position, data)
        notifyItemInserted(position)
    }

    protected fun addData(listData: List<Any>) {
        mDataSet.addAll(listData)
        notifyItemRangeInserted(mDataSet.lastIndex - listData.size + 1, listData.size)
    }

    protected fun addData(position: Int, listData: List<Any>) {
        mDataSet.addAll(position, listData)
        notifyItemRangeInserted(position, listData.size)
    }

    protected fun removeData(data: Any) {
        val position = mDataSet.indexOf(data)
        if (position > -1) {
            removeAt(position)
        }
    }

    protected fun removeAt(position: Int) {
        mDataSet.removeAt(position)
        notifyItemRemoved(position)
    }

    protected fun removeRange(start: Int, itemCount: Int) {
        mDataSet.removeRange(start, start + itemCount - 1)
        notifyItemRangeRemoved(start, itemCount)
    }


}