package com.hus.gradletest.setup

import android.content.Context
import com.hus.core.network.di.networkModule
import com.hus.data.datamodule.dataModule
import com.hus.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun Context.koinContainer() {
    startKoin {
        androidContext(this@koinContainer)
        modules(
            listOf(
                networkModule,
                dataModule,
                domainModule,

            )
        )
    }
}