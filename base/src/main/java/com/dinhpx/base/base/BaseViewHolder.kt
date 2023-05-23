package com.dinhpx.base.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(data: T)

    open fun onBindPayLoad(data: T, payload: List<Any>) {}

}