package com.dinhpx.smallexamples.grid

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dinhpx.base.base.BaseFragment
import com.dinhpx.smallexamples.databinding.FragmentGridBinding
import com.dinhpx.smallexamples.home.ButtonAdapter
import com.dinhpx.smallexamples.home.FunctionEntity
import com.dinhpx.smallexamples.home.MainViewModel

class GridFragment : BaseFragment() {
    override val binding by lazy {
        FragmentGridBinding.inflate(layoutInflater)
    }
    override val viewModel by viewModels<MainViewModel>()
    private val listButton = mutableListOf<FunctionEntity>()

    private val adapter by lazy { ButtonAdapter() }


    override fun initView() {
        repeat(40) {
            listButton.add(FunctionEntity(it.toString()))
        }
        binding.rvButton.adapter = adapter
        (binding.rvButton.layoutManager as? GridLayoutManager)?.spanSizeLookup =
            object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when ((listButton[position].name.toInt()) % 10) {
                        0 -> 4
                        else -> 1
                    }
                }

            }
        adapter.resetData(listButton)

        adapter.onLongClickItem = {
            listButton.remove(it)
            println("DINHPXTEST listButton ${listButton.size}")
        }
    }

    override fun initObserve() {
    }

    override fun initListener() {
    }


}