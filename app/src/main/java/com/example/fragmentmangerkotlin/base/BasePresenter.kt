package com.example.fragmentmangerkotlin.base

import android.os.Build
import androidx.annotation.RequiresApi

abstract class BasePresenter() : BaseModel.OnListener {

    private var view: BaseView? = null
    private var model: BaseModel? = null

    open fun BasePresenter(view: BaseView?, model: BaseModel?) {
        this.view = view
        this.model = model
    }

    @RequiresApi(Build.VERSION_CODES.O)
    open fun onCreate() {
        view?.setContentView()
    }

    override fun onConnectionSuccess(
        sTag: String?,
        sRt: String?,
        sMsgText: String?,
        objectData: Any?
    ) {
    }

    override fun onConnectionFailed(sTag: String?, sResponseCode: String?) {
    }

    override fun onNetworkFailed(sTag: String?) {
    }
}