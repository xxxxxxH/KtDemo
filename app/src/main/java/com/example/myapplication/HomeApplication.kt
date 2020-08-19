package com.example.myapplication

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class HomeApplication: Application() {

    val isDebugger = false

    override fun onCreate() {
        super.onCreate()
        if (!isDebugger){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}