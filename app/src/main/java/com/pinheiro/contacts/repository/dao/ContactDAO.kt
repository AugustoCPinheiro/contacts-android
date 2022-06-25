package com.pinheiro.contacts.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pinheiro.contacts.models.Contact

@Dao
interface ContactDAO {
    @Query("SELECT * from contact")
    fun getAll(): List<Contact>

    @Insert
    fun insertAll(vararg contact: Contact)
}