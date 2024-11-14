package com.hus.data.auth.service

import com.hus.data.auth.models.LoginRequest
import io.ktor.client.statement.HttpResponse

interface IAuth {

    suspend fun login(request: LoginRequest): HttpResponse

}