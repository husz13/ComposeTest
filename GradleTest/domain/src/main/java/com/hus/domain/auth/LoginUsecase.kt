package com.hus.domain.auth

import com.hus.data.auth.models.LoginRequest
import com.hus.data.auth.models.LoginResponse
import com.hus.data.auth.repo.IAuthRepo
import kotlinx.coroutines.flow.Flow

class LoginUsecase(private val repo:IAuthRepo):ILoginUsecase {
    override suspend fun invoke(request: LoginRequest): Flow<LoginResponse?> {
        return repo.login(request)
    }

}