package com.hus.data.datamodule

import com.hus.data.auth.repo.AuthRepo
import com.hus.data.auth.repo.IAuthRepo
import com.hus.data.auth.service.AuthService
import com.hus.data.auth.service.IAuth
import org.koin.dsl.module

val dataModule = module {
    single<IAuth>{ AuthService(get()) }
    single <IAuthRepo>{ AuthRepo(get(),get()) }
}