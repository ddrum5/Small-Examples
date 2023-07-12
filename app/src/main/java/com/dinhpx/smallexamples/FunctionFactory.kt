package com.dinhpx.smallexamples

import androidx.fragment.app.Fragment
import com.dinhpx.smallexamples.home.FunctionEntity
import com.dinhpx.smallexamples.load_more_recyclerview.LoadMoreExampleFragment
import com.dinhpx.smallexamples.pactice_coroutine.CoroutineExampleFragment
import java.util.HashMap
import java.util.regex.Pattern

object FunctionFactory  {

    private const val LOAD_MORE = "LOAD_MORE"
    private const val CoroutineExampleFragment = "CoroutineExampleFragment"


    fun getListFunction(): List<FunctionEntity> {
      return mutableListOf(
          FunctionEntity(LOAD_MORE),
          FunctionEntity(CoroutineExampleFragment),
      )
    }

    fun getFunctionFragment(function: FunctionEntity): Fragment? {
        return when (function.name) {
            LOAD_MORE -> LoadMoreExampleFragment()
            CoroutineExampleFragment -> CoroutineExampleFragment()
            else -> null
        }
    }
}
