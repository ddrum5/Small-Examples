package com.dinhpx.smallexamples.load_more_recyclerview

import androidx.fragment.app.viewModels
import com.dinhpx.base.base.BaseFragment
import com.dinhpx.loadmorerecyclerview.CallBackLoadMore
import com.dinhpx.smallexamples.databinding.FragmentLoadmoreRecyclerviewBinding

class LoadMoreExampleFragment : BaseFragment() {
    override val binding by lazy { FragmentLoadmoreRecyclerviewBinding.inflate(layoutInflater) }

    override val viewModel by viewModels<LoadMoreExampleViewModel>()

    private val adapter by lazy { LoadMoreExampleAdapter() }

    override fun initView() {
        binding.rvLoadMore.adapter = adapter
        adapter.showLoading()
        viewModel.getData()

        binding.rvLoadMore.setCallBackLoadMoreData(object : CallBackLoadMore {
            override fun onLoadData() {
                viewModel.getData()
            }

            override fun canLoadMore(): Boolean {
                return viewModel.canLoadMore
            }
        })
    }

    override fun initObserve() {
        viewModel.listItemDataLiveData.observe(this) {
            adapter.addMoreData(it)
        }
    }

    override fun initListener() {
    }
}