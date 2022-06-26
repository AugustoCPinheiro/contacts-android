package com.pinheiro.contacts.repository

import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.api.ContactsApi
import com.pinheiro.contacts.util.network.ApiResponse
import com.pinheiro.contacts.util.network.BaseRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteContactsRepository(private val contactsApi: ContactsApi) : BaseRemoteRepository(),
    ContactsRepository {
    override fun getAllContacts(): Flow<List<Contact>> {

        return flow {
            when (val result = safeApiCall { contactsApi.getContacts() }) {
                is ApiResponse.Success -> {
                    result.data?.let {
                        emit(it)
                    }
                }
                is ApiResponse.Error -> {
                    throw result.exception!!
                }
            }
        }
    }

    override fun getContact(id: Int): Flow<Contact> {
        return flow {
            val result = contactsApi.getContact(id)
            if (result.isSuccessful) {
                emit(result.body()!!)
            }
        }
    }

    override fun saveContact(contact: Contact): Flow<Unit> {
        return flow {
            // TODO "Create better abstraction for api and repository communication"
            when (val result = safeApiCall { contactsApi.createContact(contact) }) {
                is ApiResponse.Success -> {
                    emit(Unit)
                }
                is ApiResponse.Error -> {
                    throw result.exception!!
                }
            }
        }
    }
}