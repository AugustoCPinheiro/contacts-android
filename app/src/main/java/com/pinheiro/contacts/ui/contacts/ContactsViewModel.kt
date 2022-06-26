package com.pinheiro.contacts.ui.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinheiro.contacts.repository.ContactsRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ContactsViewModel(private val remoteRepository: ContactsRepository) : ViewModel() {
    private val _contactsState =
        MutableStateFlow<ContactsState>(ContactsState.Initial)
    val contactsState: StateFlow<ContactsState> = _contactsState

    init {
        viewModelScope.launch {
            _contactsState.value = ContactsState.Loading
            remoteRepository.getAllContacts()
                .catch { _contactsState.value = ContactsState.Error }.collect {
                    _contactsState.value = ContactsState.Success(it)
                }
        }
    }

}