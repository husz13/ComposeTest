package com.hus.domain.di

import com.hus.domain.auth.ILoginUsecase
import com.hus.domain.auth.LoginUsecase
import org.koin.dsl.module

val domainModule = module {
    single <ILoginUsecase>{ LoginUsecase(get()) }

}