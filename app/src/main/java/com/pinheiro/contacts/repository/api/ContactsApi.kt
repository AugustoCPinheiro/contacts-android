package com.pinheiro.contacts.repository.api

import com.pinheiro.contacts.BuildConfig
import com.pinheiro.contacts.models.Contact
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContactsApi {

    @GET("/contacts")
    suspend fun getContacts(): Response<List<Contact>>

    @GET("/contacts/{id}")
    suspend fun getContact(@Path("id") id: Int): Response<Contact>

    @POST("/contacts")
    suspend fun createContact(@Body contact: Contact): Response<Unit>

    companion object {
        fun create(): ContactsApi {
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ContactsApi::class.java)
        }
    }
}