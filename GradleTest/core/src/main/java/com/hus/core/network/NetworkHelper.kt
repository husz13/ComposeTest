package com.hus.core.network



import com.hus.core.network.models.GeneralHTTPException
import com.hus.core.network.models.NetworkException
import com.hus.core.network.models.Result
import com.hus.core.network.models.UnauthorizedException
import com.hus.core.network.models.UnknownException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import java.io.IOException

class NetworkHelper {
    suspend inline fun <reified T> processCall(
        networkCall:  () -> HttpResponse
    ): T? {
        val response = try {
            networkCall()
        } catch (throwable: IOException) {
            throw NetworkException
        } catch (throwable: Throwable) {
            throw UnknownException("Unknown Exception")
        }
        return handleResponse(response)
    }

    suspend inline fun <reified T> handleResponse(response: HttpResponse): T? {
        when (response.status.value) {
            in HttpStatusCode.OK.value..HttpStatusCode.MultipleChoices.value -> {
                val dataPayload = response.body<Result<T>>()
                return dataPayload.data
            }

            HttpStatusCode.Unauthorized.value -> throw UnauthorizedException()

            in HttpStatusCode.BadRequest.value..HttpStatusCode.InternalServerError.value -> {
                val errorBody = response.body<Result<T>>()
                throw GeneralHTTPException(
                    errorMessage = errorBody.message,
                )
            }

            else -> throw UnknownException("Unknown Exception")
        }
    }
}
