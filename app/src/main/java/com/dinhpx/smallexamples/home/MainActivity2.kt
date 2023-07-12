package com.dinhpx.smallexamples.home

import android.app.ActivityManager
import android.content.Context
import android.view.KeyEvent
import androidx.activity.viewModels
import com.dinhpx.base.base.BaseActivity
import com.dinhpx.smallexamples.databinding.ActivityMainBinding
import com.dinhpx.smallexamples.databinding.ActivityMainTestBinding
import java.util.*


class MainActivity2 : BaseActivity(), KeyEvent.Callback {

    override val binding by lazy { ActivityMainTestBinding.inflate(layoutInflater) }

    override val viewModel by viewModels<MainViewModel>()

    override fun initView() {



        var mString = this.javaClass.simpleName + "\n\n"


        // Getting the instance of ActivityManager
        val mActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        // Getting the tasks in the form of a list
        val mRecentTasks: List<ActivityManager.RunningTaskInfo> = Objects.requireNonNull(mActivityManager).getRunningTasks(Int.MAX_VALUE)


        // Creating a string of each index of the list
        for (i in mRecentTasks.indices){
            mString = mString + " " + mRecentTasks[i].baseActivity?.toShortString() + " " + mRecentTasks[i].id + "\n\n"
        }


        binding.textView.text = mString


    }

    override fun initObserve() {
    }

    override fun initListener() {
    }


}