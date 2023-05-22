package com.dinhpx.loadmorerecyclerview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinhpx.loadmorerecyclerview.databinding.ActivityMainBinding
import com.dinhpx.loadmorerecyclerview.adapter.LoadMoreAdapter


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val adapter by lazy { LoadMoreAdapter() }

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView.adapter = adapter
        layoutManager = binding.recyclerView.layoutManager as LinearLayoutManager
        viewModel.getData()

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val lastItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()
                val totalItem = layoutManager.itemCount - 1

                if (!adapter.isLoading() && lastItemPosition == totalItem && viewModel.canLoadMore) {
                    adapter.showLoading()
                    viewModel.getData()
                    recyclerView.smoothScrollToPosition(lastItemPosition + 1)
                }
            }
        })




        viewModel.listItemDataLiveData.observe(this) {
            adapter.addListData(it)
        }

    }


}