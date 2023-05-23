package com.dinhpx.base.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment : Fragment() {

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserve()
        initListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("DINHPXTEXT", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DINHPXTEXT", "onDestroy")
    }

    abstract fun initView()
    abstract fun initObserve()
    abstract fun initListener()

}