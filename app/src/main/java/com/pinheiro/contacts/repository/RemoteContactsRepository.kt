package com.pinheiro.contacts.repository

import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.api.ContactsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteContactsRepository(private val contactsApi: ContactsApi) : ContactsRepository {
    override fun getAllContacts(): Flow<List<Contact>> {

        return flow {
            val result = contactsApi.getContacts()
            if (result.isSuccessful) {
                emit(result.body()!!)
            }

        }
    }

    override fun getContact(id: Int): Flow<Contact> {
        TODO("Not yet implemented")
    }

    override fun saveContact(contact: Contact) {
        TODO("Not yet implemented")
    }
}