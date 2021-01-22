package com.example.fragmentmangerkotlin.base

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.fragmentmangerkotlin.KTApplication
import com.example.fragmentmangerkotlin.MainActivity
import com.example.fragmentmangerkotlin.util.LogUtils

abstract class BaseActivity : FragmentActivity(), BaseView {

    // 調整亮度
    var nowScreenValue = 0 // 記住原本亮度
    
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    /**
     * 跳toast
     */
    override fun showToast() {
        Toast.makeText(this, "ＯＫ", Toast.LENGTH_SHORT).show()
    }
    /**
     * show dialog
     */
    override fun showMsg() {
        val dialog = AlertDialog.Builder(this)
            .setMessage("出來了")
            .setTitle("Ya")
            .setPositiveButton("OK") { _, _ ->
            }
            .setNeutralButton("Cancel", null)

        runOnUiThread {
            dialog.show()
        }
    }

    /**
     * 重啟App
     */
    protected open fun restartApp() {
        runOnUiThread {
            val intent = Intent(this@BaseActivity, MainActivity::class.java)
            this@BaseActivity.startActivity(intent)
            overridePendingTransition(0, 0)
            System.exit(0)
        }
    }

    /**
     * 將當前頁面亮度提高至最亮
     */
    fun setScreenLightMax(){
        val scLight = this.window.attributes
        // 拿到目前螢幕亮度
        val resolver: ContentResolver = KTApplication.instance.getContentResolver()
        try {
            //亮度值範圍為0~255
            nowScreenValue = Settings.System.getInt(
                resolver,
                Settings.System.SCREEN_BRIGHTNESS
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //screenBrightness的值範圍為0~1 單位為float
        scLight.screenBrightness = java.lang.Float.valueOf(1f)
        this.window.attributes = scLight
    }

    /**
     * 還原螢幕亮度
     */
    fun setScreenLightOrigin(){
        val lp = this.window.attributes

        //記得將單位0~255(Int)轉換為0-1f
        lp.screenBrightness = java.lang.Float.valueOf(nowScreenValue * (1f / 255f))
        this.window.attributes = lp
    }

    override fun getContext(): Context = this


    override fun onStart() {
        super.onStart()
        onFirstStart()
        LogUtils.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.d("onPause")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.d("onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
//        mPresenter.detachView()
        LogUtils.d("onDestroy")
    }
}