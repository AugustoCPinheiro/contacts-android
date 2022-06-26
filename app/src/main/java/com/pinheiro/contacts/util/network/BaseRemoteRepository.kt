package com.pinheiro.contacts.util.network

import retrofit2.Response
import java.lang.Exception

abstract class BaseRemoteRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResponse<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return ApiResponse.Success(body)
                }
            }
            return error(response.code(), "${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(RANDOM_RESPONSE_CODE, e.message ?: e.toString())
        }
    }

    private fun <T> error(code: Int, errorMessage: String): ApiResponse<T> {
        //TODO create exceptions for different scenarios
        return when (code) {
            in 0..1000 -> {
                ApiResponse.Error(BackendErrorException(code, "Api call fail $errorMessage"))
            }
            else -> {
                ApiResponse.Error(NoConnectionException())
            }
        }

    }

    private companion object{
        const val RANDOM_RESPONSE_CODE = -1
    }
}