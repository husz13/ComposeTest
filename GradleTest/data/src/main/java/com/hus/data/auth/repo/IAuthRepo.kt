package com.hus.data.auth.repo

import com.hus.data.auth.models.LoginRequest
import com.hus.data.auth.models.LoginResponse
import java.util.concurrent.Flow

interface IAuthRepo {

    suspend fun login(request: LoginRequest): kotlinx.coroutines.flow.Flow<LoginResponse?>
}