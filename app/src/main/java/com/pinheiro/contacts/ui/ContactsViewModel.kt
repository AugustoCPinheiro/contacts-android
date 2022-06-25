package com.pinheiro.contacts.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.ContactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ContactsViewModel(private val remoteRepository: ContactsRepository) : ViewModel() {
    private val _contactsRequestState =
        MutableStateFlow<ContactsRequestState>(ContactsRequestState.Initial)
    val contactsRequestState: StateFlow<ContactsRequestState> = _contactsRequestState

    init {
        viewModelScope.launch {
            _contactsRequestState.value = ContactsRequestState.Loading
            remoteRepository.getAllContacts().collect {
                _contactsRequestState.value = ContactsRequestState.Success(it)
            }
        }
    }

    sealed class ContactsRequestState {
        class Success(val contacts: List<Contact>) : ContactsRequestState()
        object Loading : ContactsRequestState()
        object Initial : ContactsRequestState()
    }
}