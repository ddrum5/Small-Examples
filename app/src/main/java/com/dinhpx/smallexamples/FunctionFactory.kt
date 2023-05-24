package com.dinhpx.smallexamples

import androidx.fragment.app.Fragment
import com.dinhpx.smallexamples.load_more_recyclerview.LoadMoreExampleFragment


enum class ButtonEnum(name: String, fragment: Fragment) {
    LOAD_MORE_ADAPTER("Load more adapter", LoadMoreExampleFragment()),
    PROGRESS_TAB("Progress tab", LoadMoreExampleFragment())

    /*companion object {
        fun getFunction(type: Int): Fragment {
            return when (type) {
                LOAD_MORE -> LoadMoreExampleFragment()
                else -> LoadMoreExampleFragment()
            }
        }
    }*/


}

