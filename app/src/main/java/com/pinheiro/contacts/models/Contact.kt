package com.pinheiro.contacts.models

import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phoneNumber: String
)