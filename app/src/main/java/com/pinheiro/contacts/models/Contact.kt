package com.pinheiro.contacts.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class Contact(
    val id: Int,
    val name: String,
    @SerializedName("phone") val phoneNumber: String
)