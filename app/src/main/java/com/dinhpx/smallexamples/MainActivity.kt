package com.dinhpx.smallexamples

import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.dinhpx.base.base.BaseActivity
import com.dinhpx.smallexamples.databinding.ActivityMainBinding
import com.dinhpx.smallexamples.load_more_recyclerview.LoadMoreExampleFragment


class MainActivity : BaseActivity() {

    override val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override val viewModel by viewModels<MainViewModel>()

    private val adapter by lazy { ButtonAdapter() }

    override fun initView() {
        binding.rvButton.adapter = adapter
        adapter.resetData(ButtonEnum.values().toList())
    }

    override fun initObserve() {

    }

    override fun initListener() {
        adapter.onClickItem = {
            openFunction(it.)
        }
    }


    private fun openFunction(fragment: Fragment) {
        binding.fragmentHome.visibility = View.VISIBLE
        binding.rvButton.visibility = View.GONE
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHome, LoadMoreExampleFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
            supportFragmentManager.popBackStackImmediate()
            binding.fragmentHome.visibility = View.GONE
            binding.rvButton.visibility = View.VISIBLE
        }
    }

}