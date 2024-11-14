package com.hus.gradletest.setup.app

import android.app.Application
import com.hus.gradletest.setup.koinContainer

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        koinContainer()
    }


}