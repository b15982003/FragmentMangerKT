package com.example.fragmentmangerkotlin.util

import android.content.Context
import android.util.Log
import com.example.fragmentmangerkotlin.BuildConfig

class Util {


    /**
     * 是否為Debug模式
     */
    fun checkDebug(): Boolean {
        return BuildConfig.DEBUG
    }

}