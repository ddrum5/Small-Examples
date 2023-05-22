package com.dinhpx.base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity : AppCompatActivity() {

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        initObserve()
        initListener()
    }


    abstract fun initView()
    abstract fun initObserve()
    abstract fun initListener()

}