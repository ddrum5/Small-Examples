package com.dinhpx.smallexamples.home

import androidx.fragment.app.Fragment
import com.dinhpx.smallexamples.load_more_recyclerview.LoadMoreExampleFragment


data class FunctionEntity(val name: String, val type: Int)

object FunctionFactory {

    private const val LOAD_MORE_ADAPTER = 0

    fun getFragmentFunction(type: Int): Fragment? {
        return when (type) {
            LOAD_MORE_ADAPTER -> LoadMoreExampleFragment()
            else -> null
        }
    }

    fun getListFunction(): List<FunctionEntity> {
        return mutableListOf(
            FunctionEntity("Load more adapter", LOAD_MORE_ADAPTER)
        )
    }
}
