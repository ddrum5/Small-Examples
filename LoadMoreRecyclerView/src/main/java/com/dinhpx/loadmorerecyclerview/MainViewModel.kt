package com.dinhpx.loadmorerecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinhpx.loadmorerecyclerview.data.ItemData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    companion object {
        private const val TOTAL_ITEM = 50
        private const val TOTAL_PAGE = 10
        private const val PAGE_SIZE = TOTAL_ITEM / TOTAL_PAGE
    }

    private val dataAll = mutableListOf<ItemData>()
    private var page = 0
    var canLoadMore = true

    init {
        repeat(TOTAL_ITEM) {
            dataAll.add(ItemData(it.toString()))
        }
    }

    val listItemDataLiveData = MutableLiveData<List<ItemData>>()
    fun getData() {
        viewModelScope.launch {
            if (canLoadMore) {
                delay(1500)
                val data = dataAll.slice(page * PAGE_SIZE until page * PAGE_SIZE + PAGE_SIZE)
                listItemDataLiveData.postValue(data)
                page++
                canLoadMore = page < TOTAL_PAGE
            }
        }
    }
}