package com.pinheiro.contacts.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.ContactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ContactsViewModel(private val repository: ContactsRepository): ViewModel() {
    private val _contacts =  MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts

    init {
        viewModelScope.launch {
            repository.getAllContacts().collect {
                _contacts.value = it
            }
        }
    }
}