package com.pinheiro.contacts.repository.api

import com.pinheiro.contacts.models.Contact
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ContactsApi {

    @GET("/contacts")
    fun getContacts(): Response<List<Contact>>

    companion object {
        fun create(): ContactsApi {
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder().baseUrl("").client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ContactsApi::class.java)
        }
    }
}