package com.dinhpx.smallexamples.pactice_coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dinhpx.base.base.BaseViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class CoroutineExampleViewModel : BaseViewModel() {


    val liveData = MutableLiveData<Int>()
        val a = viewModelScope

    fun test() = runBlocking {
        repeat(100) {
            liveData.postValue(it)
        }
    }

    suspend fun fun1() {
        delay(5999)
        println("fun 1")
    }

    suspend fun fun2() {
        delay(2000)
        println("fun 2")
    }

}





