package com.dinhpx.smallexamples

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.text.TextUtils
import android.util.Log
import android.util.TypedValue
import java.text.SimpleDateFormat
import java.util.*


class Utils private constructor() {
    companion object {
        const val EN_LANG = "EN"
        const val VN_LANG = "VI"
        private var instance: Utils? = null

        @JvmStatic
        fun g(): Utils {
            if (instance == null) instance = Utils()
            return instance!!
        }
    }

    private var widthScreen = 0
    private var heightScreen = 0

    fun getScreenWidth(): Int {
        genScreenSize()
        return widthScreen
    }

    fun getScreenHeight(): Int {
        genScreenSize()
        return heightScreen
    }

    private fun genScreenSize() {
        try {
            val displayMetrics = Resources.getSystem().displayMetrics
            heightScreen = displayMetrics.heightPixels
            widthScreen = displayMetrics.widthPixels
        } catch (e: java.lang.Exception) {
            Log.wtf("EXX", e)
        }
    }

    fun getDPtoPX(context: Context, dp: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics
        ).toInt()
    }










}