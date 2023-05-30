package com.dinhpx.smallexamples

import androidx.fragment.app.Fragment
import com.dinhpx.smallexamples.grid.GridFragment
import com.dinhpx.smallexamples.home.FunctionEntity
import com.dinhpx.smallexamples.load_more_recyclerview.LoadMoreExampleFragment

object FunctionFactory  {

    private const val LOAD_MORE = "LOAD_MORE"
    private const val PROGRESS_TAB = "PROGRESS_TAB"
    private const val GRID_MANAGER = "GRID_MANAGER"


    fun getListFunction(): List<FunctionEntity> {
      return mutableListOf(
          FunctionEntity(LOAD_MORE),
          FunctionEntity(PROGRESS_TAB),
          FunctionEntity(GRID_MANAGER),
      )
    }
    fun getFunctionFragment(function: FunctionEntity): Fragment? {
        return when (function.name) {
            LOAD_MORE -> LoadMoreExampleFragment()
            GRID_MANAGER -> GridFragment()
            PROGRESS_TAB -> null
            else -> null
        }
    }
}
