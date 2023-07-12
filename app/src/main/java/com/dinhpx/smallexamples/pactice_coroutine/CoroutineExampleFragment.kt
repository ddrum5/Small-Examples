package com.dinhpx.smallexamples.pactice_coroutine

import androidx.fragment.app.viewModels
import com.dinhpx.base.base.BaseFragment
import com.dinhpx.smallexamples.databinding.FragmentGridBinding


class CoroutineExampleFragment : BaseFragment(){
    override val binding by lazy {
        FragmentGridBinding.inflate(layoutInflater)
    }
    override val viewModel by viewModels<CoroutineExampleViewModel>()


    override fun initView() {

    }

    override fun initObserve() {
    }

    override fun initListener() {

    }


}