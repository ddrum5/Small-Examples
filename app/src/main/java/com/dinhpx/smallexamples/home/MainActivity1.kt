package com.dinhpx.smallexamples.home

import android.app.ActivityManager
import android.content.Intent
import android.view.KeyEvent
import androidx.activity.viewModels
import com.dinhpx.base.base.BaseActivity
import com.dinhpx.smallexamples.databinding.ActivityMainBinding
import com.dinhpx.smallexamples.databinding.ActivityMainTestBinding


class MainActivity1 : BaseActivity(), KeyEvent.Callback {

    override val binding by lazy { ActivityMainTestBinding.inflate(layoutInflater) }

    override val viewModel by viewModels<MainViewModel>()

    override fun initView() {

        val mngr = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        val taskList = mngr.getRunningTasks(10)


        var mString = this.javaClass.simpleName + "\n\n"
        taskList.forEach {
            mString = mString + " " + it.topActivity + " " + it.id + "\n\n"
        }

        binding.textView.text = mString

    }

    override fun initObserve() {
    }

    override fun initListener() {

        binding.textView.setOnClickListener {
            startActivity(
                Intent(this, MainActivity2::class.java)
            )
        }
    }


}