package com.dinhpx.loadmorerecyclerview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LoadMoreRecyclerView : RecyclerView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }


    private lateinit var callBackLoadMore: CallBackLoadMore
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var loadMoreAdapter: LoadMoreAdapter

    private fun init() {
        mLayoutManager = layoutManager as LinearLayoutManager
        addOnScrollListener(scrollListener)
    }

    private val scrollListener = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (!loadMoreAdapter.isLoading() && callBackLoadMore.canLoadMore() &&
                mLayoutManager.findLastCompletelyVisibleItemPosition() == mLayoutManager.itemCount - 1
            ) {
                recyclerView.post {
                    loadMoreAdapter.showLoading()
                    smoothScrollToPosition(mLayoutManager.findLastCompletelyVisibleItemPosition() + 1)
                    callBackLoadMore.onLoadData()
                }
            }
        }
    }

    fun setCallBackLoadMoreData(callBackLoadMore: CallBackLoadMore) {
        this.callBackLoadMore = callBackLoadMore
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
        loadMoreAdapter = adapter as LoadMoreAdapter
    }


}