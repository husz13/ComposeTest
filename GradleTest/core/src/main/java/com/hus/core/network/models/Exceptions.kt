package com.hus.core.network.models

object NetworkException : Exception("Network Exception") {
    private fun readResolve(): Any = NetworkException
}


open class GeneralHTTPException(
    val errorMessage: String?
) : Exception("General HTTP Exception")

class UnauthorizedException : Exception("Unauthorized Exception")
class UnknownException(message: String) : Exception(message)