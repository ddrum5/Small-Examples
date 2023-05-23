package com.dinhpx.loadmorerecyclerview

interface CallBackLoadMore {
    fun onLoadData()
    fun canLoadMore(): Boolean
}