package com.pinheiro.contacts.repository

import com.pinheiro.contacts.models.Contact
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {
    fun getAllContacts(): Flow<List<Contact>>

    fun getContact(id: Int): Flow<Contact>

    fun saveContact(contact: Contact): Flow<Unit>
}