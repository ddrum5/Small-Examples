package com.dinhpx.loadmorerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.dinhpx.base.base.BaseRclvAdapter
import com.dinhpx.base.base.BaseViewHolder
import com.dinhpx.loadmorerecyclerview.databinding.ItemLoadingBinding

abstract class LoadMoreAdapter : BaseRclvAdapter() {
    companion object {
        private const val LOADING_TYPE = -1
    }


    abstract fun createCustomVH(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    open fun setCustomLoading(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewBinding {
        return ItemLoadingBinding.inflate(layoutInflater, parent, false)
    }

    override fun getItemViewType(position: Int): Int {
        return when (mDataSet[position]) {
            is ItemLoading -> LOADING_TYPE
            else -> super.getItemViewType(position)
        }
    }

    override fun createVH(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return if (viewType == LOADING_TYPE) {
            LoadingVH(setCustomLoading(layoutInflater, parent, viewType))
        } else {
            createCustomVH(layoutInflater, parent, viewType)
        }
    }

    fun addMoreData(listData: List<Any>) {
        hideLoading()
        addData(listData)
    }

    fun isLoading(): Boolean {
        return mDataSet.lastOrNull() is ItemLoading
    }

    fun showLoading() {
        if (!isLoading()) {
            addData(ItemLoading())
        }
    }

    private fun hideLoading() {
        if (isLoading()) {
            removeAt(mDataSet.lastIndex)
        }
    }

    class LoadingVH(binding: ViewBinding) : BaseViewHolder<ItemLoading>(binding) {
        override fun onBind(data: ItemLoading) {}
    }

    class ItemLoading {}

}