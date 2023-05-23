package com.dinhpx.base.base.extensions

fun MutableList<*>.removeRange(start: Int, end: Int) {
    if (start in this.indices && end in this.indices) {
        for (i in end downTo start) {
            this.removeAt(i)
        }
    }
}