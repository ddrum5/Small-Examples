package com.dinhpx.smallexamples.load_more_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.viewbinding.ViewBinding
import com.dinhpx.base.base.BaseViewHolder
import com.dinhpx.loadmorerecyclerview.LoadMoreAdapter
import com.dinhpx.loadmorerecyclerview.databinding.ItemDataBinding
import com.dinhpx.smallexamples.R
import com.dinhpx.smallexamples.databinding.ItemLoadingCustomBinding

class LoadMoreExampleAdapter : LoadMoreAdapter() {

    override fun getItemViewType(position: Int): Int {
        return when (mDataSet[position]) {
            is ItemData -> {
                1
            }
            is ItemData2 -> {
                2
            }
            else -> {
                super.getItemViewType(position)
            }
        }
    }

    override fun createCustomVH(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            1 -> {
                SimpleVH(ItemDataBinding.inflate(layoutInflater, parent, false))
            }
            else -> {
                SimpleVH2(ItemDataBinding.inflate(layoutInflater, parent, false))
            }
        }
    }

    override fun setCustomLoading(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewBinding {
        return ItemLoadingCustomBinding.inflate(layoutInflater, parent, false)
    }

    class SimpleVH(private val binding: ItemDataBinding) : BaseViewHolder<ItemData>(binding) {
        override fun onBind(data: ItemData) {
            binding.textView.text = data.title
        }
    }

    class SimpleVH2(private val binding: ItemDataBinding) : BaseViewHolder<ItemData2>(binding) {
        override fun onBind(data: ItemData2) {
            binding.textView.text = data.title
            binding.textView.setBackgroundResource(R.color.purple_200)
        }
    }

}