package com.dinhpx.smallexamples.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dinhpx.base.base.BaseViewModel
import com.dinhpx.smallexamples.load_more_recyclerview.LoadMoreExampleFragment

class MainViewModel : BaseViewModel() {

    companion object {
        private const val LOAD_MORE = 0
        private const val PROGRESS_TAB = 1
    }

    val listFunction = mutableListOf<FunctionEntity>()

    init {
        listFunction.addAll(
            mutableListOf(
                FunctionEntity("Load more adapter", LOAD_MORE),
                FunctionEntity("Progress tab", PROGRESS_TAB)
            )
        )
    }

    fun getFunction(type: Int): Fragment? {
        return when (type) {
            LOAD_MORE -> LoadMoreExampleFragment()
            PROGRESS_TAB -> null
            else -> null
        }
    }
}