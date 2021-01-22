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
//        if (RtDefine.s0000.equals(sRt)) {
//            onConnectionSuccessRt0(sTag, sMsgText, objectData)
//        } else if (RtDefine.s9999.equals(sRt)) { // 顯示錯誤訊息，按下確定，關閉SDK(含SDK全部畫面)
//            onConnectionSuccessRt9999(sTag, sMsgText, objectData)
//        } else if (RtDefine.s9990.equals(sRt) || RtDefine.s9901.equals(sRt)) { // 顯示錯誤訊息，按下確定，關閉SDK(含SDK全部畫面)
//            onConnectionSuccessTimeout(sRt, sTag, sMsgText, objectData)
//        }
    }

    override fun onConnectionFailed(sTag: String?, sResponseCode: String?) {
//        if (null != view && null != model) {
//            view.closeLoading()
//            view.showConnectionFailed(sResponseCode, -1, null)
//            view.openButton()
//        }
    }

    override fun onNetworkFailed(sTag: String?) {
//        if (null != view && null != model) {
//            view.closeLoading()
//            view.showNetworkFailed(-1, null)
//            view.openButton()
//        }
    }
}