package com.example.fragmentmangerkotlin

import android.app.Application
import kotlin.properties.Delegates

class KTApplication : Application() {
    companion object {
        // 單利不會是null 所以使用notNull委託

        var instance: KTApplication by Delegates.notNull()

    }
    override fun onCreate() {
        super.onCreate()
        instance=this;

    }
}