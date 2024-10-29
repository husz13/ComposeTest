package com.hus.data.auth.service

import com.hus.data.auth.models.LoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse

class AuthService(private  val client: HttpClient ) :IAuth{



    override suspend fun login(request: LoginRequest): HttpResponse {
        return client.post("/api/restaurant/login"){
            setBody(request)

        }
    }

}