package com.hus.domain.auth

import com.hus.data.auth.models.LoginRequest
import com.hus.data.auth.models.LoginResponse
import kotlinx.coroutines.flow.Flow

interface ILoginUsecase {
    suspend fun invoke(request: LoginRequest): Flow<LoginResponse?>
}