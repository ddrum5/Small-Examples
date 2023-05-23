package com.dinhpx.smallexamples.home

import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.dinhpx.base.base.BaseActivity
import com.dinhpx.smallexamples.R
import com.dinhpx.smallexamples.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    override val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override val viewModel by viewModels<MainViewModel>()

    private val adapter by lazy { ButtonAdapter() }

    override fun initView() {
        binding.rvButton.adapter = adapter
        adapter.resetData(viewModel.listFunction)
    }

    override fun initObserve() {

    }

    override fun initListener() {
        adapter.onClickItem = {
            openFunction(viewModel.getFunction(it.type))
        }
    }

    private fun openFunction(fragment: Fragment?) {
        if (fragment == null) {
            showDiaLog("Đang code")
        } else {
            binding.fragmentHome.visibility = View.VISIBLE
            binding.rvButton.visibility = View.GONE
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentHome, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
            binding.fragmentHome.visibility = View.GONE
            binding.rvButton.visibility = View.VISIBLE
        }
    }

}