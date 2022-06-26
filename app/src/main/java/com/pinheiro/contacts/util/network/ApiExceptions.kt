package com.pinheiro.contacts.util.network

import java.lang.Exception

abstract class ApiException(val code: Int, message: String?): Exception(message)

class BackendErrorException(code: Int, message: String) : ApiException(code, message)

class NoConnectionException : ApiException(-1, null)