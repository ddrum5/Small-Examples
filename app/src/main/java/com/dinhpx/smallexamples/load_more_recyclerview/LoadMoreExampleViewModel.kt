package com.dinhpx.smallexamples.load_more_recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dinhpx.base.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadMoreExampleViewModel : BaseViewModel() {
    companion object {
        private const val TOTAL_ITEM = 48
        private const val TOTAL_PAGE = 6
        private const val PAGE_SIZE = TOTAL_ITEM / TOTAL_PAGE
    }

    private val dataAll = mutableListOf<Any>()
    private var page = 0
    var canLoadMore = true

    init {
        repeat(TOTAL_ITEM) {
            if (it % 2 == 0) {
                dataAll.add(ItemData(it.toString()))
            } else {
                dataAll.add(ItemData2(it.toString()))
            }
        }
    }

    val listItemDataLiveData = MutableLiveData<List<Any>>()
    fun getData() {
        viewModelScope.launch {
            delay(1000)
            val data = dataAll.slice(page * PAGE_SIZE until page * PAGE_SIZE + PAGE_SIZE)
            listItemDataLiveData.postValue(data)
            page++
            canLoadMore = page < TOTAL_PAGE
        }
    }
}