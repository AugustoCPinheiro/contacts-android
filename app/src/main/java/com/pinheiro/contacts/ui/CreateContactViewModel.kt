package com.pinheiro.contacts.ui

import androidx.lifecycle.ViewModel
import com.pinheiro.contacts.repository.ContactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateContactViewModel(remoteRepository: ContactsRepository) : ViewModel() {
    private val _contactRequestState = MutableStateFlow<ContactsRequestState?>(null)
    val contactsRequestState: StateFlow<ContactsRequestState?> = _contactRequestState

    companion object {
        sealed class ContactsRequestState {
            object Loading : ContactsRequestState()
        }
    }
}