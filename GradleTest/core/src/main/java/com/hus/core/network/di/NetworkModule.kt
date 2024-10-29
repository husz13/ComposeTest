package com.hus.core.network.di

import com.hus.core.network.NetworkHelper
import com.hus.core.network.client.cioClient
import org.koin.dsl.module

val networkModule = module {
    single{cioClient()}
    single { NetworkHelper() }
}