package com.dinhpx.loadmorerecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dinhpx.loadmorerecyclerview.data.ItemData
import com.dinhpx.loadmorerecyclerview.databinding.ItemDataBinding
import com.dinhpx.loadmorerecyclerview.databinding.ItemLoadingBinding

class LoadMoreAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val LOADING_TYPE = 1
    }

    private val mListData = mutableListOf<Any>()

    init {
        showLoading()
    }

    override fun getItemViewType(position: Int): Int {
        return when (mListData[position]) {
            is ItemLoading -> LOADING_TYPE
            else -> super.getItemViewType(position)
        }
    }

    override fun getItemCount() = mListData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == LOADING_TYPE) {
            LoadingVH(
                ItemLoadingBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else {
            DataVH(
                ItemDataBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? DataVH)?.onBind(mListData[position] as ItemData)
    }


    fun addListData(listData: List<ItemData>) {
        hideLoading()
        mListData.addAll(listData)
        notifyItemRangeInserted(mListData.lastIndex - listData.size + 1, listData.size)
    }

    fun isLoading(): Boolean {
        return mListData.lastOrNull() is ItemLoading
    }

    fun showLoading() {
        if (!isLoading()) {
            mListData.add(ItemLoading())
            notifyItemInserted(mListData.lastIndex)
        }
    }

    fun hideLoading() {
        if (isLoading()) {
            mListData.removeLast()
            notifyItemRemoved(mListData.lastIndex + 1)
        }
    }


    inner class DataVH(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ItemData) {
            binding.textView.text = data.title
        }
    }

    class LoadingVH(binding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ItemLoading

}