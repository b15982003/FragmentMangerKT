package com.example.fragmentmangerkotlin

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.fragmentmangerkotlin.base.BaseActivity
import com.example.fragmentmangerkotlin.bathroom.BathRoomFragment
import com.example.fragmentmangerkotlin.home.HomeFragment
import com.example.fragmentmangerkotlin.livingroom.LivinRoomFragment
import com.example.fragmentmangerkotlin.util.LogUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainView {
    @RequiresApi(Build.VERSION_CODES.O)
    var model = MainModel(this)
    var presenter : MainPresenter? = null

    // bottom Navigation 監聽
    private val listener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_a -> {
                Log.d("Ray", "getItA")
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_f -> {
                Log.d("Ray", "getItB")
                replaceFragment(LivinRoomFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_p -> {
                Log.d("Ray", "getItC")
                replaceFragment(BathRoomFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationBottom.setOnNavigationItemSelectedListener(listener)
        // first fragment
        replaceFragment(HomeFragment())

        try {
            presenter = MainPresenter( this, model)
            presenter!!.onCreate()
        } catch (e: Exception) {
            e.printStackTrace()
            restartApp()
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        overStatusBar()

        return super.onCreateView(name, context, attrs)
    }

    override fun setContentView() {
        LogUtils.d("push123")

        mainActivity_tsButton.setOnClickListener {
            LogUtils.d("push")
//            showToast()
            showMsg()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navigationView, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun overStatusBar() {
        // 4.4
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        // 延展狀態列
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0
            val window: Window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) // 確認取消半透明設置。
            window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // 全螢幕顯示，status bar 不隱藏，activity 上方 layout 會被 status bar 覆蓋。
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            ) // 配合其他 flag 使用，防止 system bar 改變後 layout 的變動。
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS) // 跟系統表示要渲染 system bar 背景。
            window.setStatusBarColor(Color.TRANSPARENT)
        }
    }

    override fun onFirstStart() {
        Log.d("Ray","onResume")
    }
}