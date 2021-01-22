package com.example.fragmentmangerkotlin.base

import android.content.Context
import androidx.annotation.StringRes

interface BaseView {
    fun showToast() // 系統 toast

    fun setContentView() // 設定畫面

    fun showMsg() // dialog

    fun getContext(): Context

    fun onFirstStart()
}