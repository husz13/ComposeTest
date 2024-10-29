package com.hus.core.network.client

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson

internal fun cioClient() : HttpClient{
    return HttpClient(CIO){
    install(ContentNegotiation){
        gson {
            setPrettyPrinting()
            serializeNulls()
            enableComplexMapKeySerialization()

        }
        engine {
            endpoint {
                connectTimeout = 30_000L
                requestTimeout = 30_000L
                keepAliveTime = 30_000L
            }




        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Ktor Logger => ", message)
                }
            }
            level = LogLevel.ALL

        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")

            }
        }
        defaultRequest {
            url("http://188.166.30.101")
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            header(HttpHeaders.ContentLanguage, "ar")
        }

    }
    }

}