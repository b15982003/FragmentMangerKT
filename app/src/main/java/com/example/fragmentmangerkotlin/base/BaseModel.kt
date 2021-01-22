package com.example.fragmentmangerkotlin.base

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
abstract class BaseModel(context: Context) {

    interface OnListener {
        fun onConnectionSuccess(
            sTag: String?, sRt: String?, sMsgText: String?, objectData: Any?
        ) // 連線成功

        fun onConnectionFailed(sTag: String?, sResponseCode: String?) // 連線失敗(ResponseCode：其他錯誤 -1)

        fun onNetworkFailed(sTag: String?) // 網路異常

    }

    protected open fun BaseModel(context: Context) {
//        context = context
//        globalVariable = globalVariable
        initial(context)
    }



    open fun initial(context: Context?) {
        if (null != context) {
        }
    }
}