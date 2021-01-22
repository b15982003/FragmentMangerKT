package com.example.fragmentmangerkotlin.base

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.fragmentmangerkotlin.MainActivity
import com.example.fragmentmangerkotlin.util.LogUtils

abstract class BaseActivity : FragmentActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
//        presenter = BasePresenter(this)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    override fun showToast() {
        Toast.makeText(this, "ＯＫ", Toast.LENGTH_SHORT).show()
    }

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