package com.dinhpx.base.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

     val TAG = "DINHPXTEST " +  this.javaClass.simpleName

}