package com.hus.data.auth.repo

import com.hus.core.network.NetworkHelper
import com.hus.data.auth.models.LoginRequest
import com.hus.data.auth.models.LoginResponse
import com.hus.data.auth.service.IAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthRepo(private val service: IAuth, private val networkHelper:NetworkHelper): IAuthRepo {
    override suspend fun login(request: LoginRequest): Flow<LoginResponse?> = flow {
    val response = networkHelper.processCall<LoginResponse> {
        service.login(request)

    }
        emit(response)

    }


}