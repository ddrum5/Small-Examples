package com.dinhpx.base.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity : AppCompatActivity() {

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    open val alertDialog by lazy { AlertDialog.Builder(this).create() }

    private val handler by lazy { Handler(Looper.getMainLooper()) }

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

    fun showDiaLog(message: String) {
        with(alertDialog) {
            setTitle(message)
            setMessage(message)
            show()
            setOnCancelListener {
                handler.removeCallbacksAndMessages(null)
            }
        }

        handler.postDelayed({
            alertDialog.dismiss()
        }, 2000)
    }

}