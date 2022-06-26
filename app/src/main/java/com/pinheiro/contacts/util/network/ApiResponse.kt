package com.pinheiro.contacts.util.network

sealed class ApiResponse<T>(
    val data: T? = null,
    val exception: ApiException? = null
) {
    class Success<T>(data: T) : ApiResponse<T>(data)

    class Error<T>(exception: ApiException, data: T? = null) :
        ApiResponse<T>(data, exception)

//    class Loading<T> : ApiResponse<T>()
}
