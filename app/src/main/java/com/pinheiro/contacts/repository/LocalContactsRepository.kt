package com.pinheiro.contacts.repository

import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.dao.ContactDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalContactsRepository(private val contactDAO: ContactDAO): ContactsRepository {
    override fun getAllContacts(): Flow<List<Contact>> {
        return flow {
            emit(contactDAO.getAll())
        }
    }

    override fun getContact(id: Int): Flow<Contact> {
        TODO("Not yet implemented")
    }

    override fun saveContact(contact: Contact): Flow<Unit> {
        contactDAO.insertAll(contact)
        TODO( "Not yet implemented")
    }
}