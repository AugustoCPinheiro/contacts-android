package com.pinheiro.contacts.ui.createContacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.ContactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CreateContactViewModel(private val remoteRepository: ContactsRepository) : ViewModel() {
    private val _contactRequestState = MutableStateFlow<CreateContactState>(CreateContactState.Init)
    val contactsRequestState: StateFlow<CreateContactState> = _contactRequestState

    fun saveContact(contact: Contact) {
        _contactRequestState.value = CreateContactState.Loading
        viewModelScope.launch {
            remoteRepository.saveContact(contact)
                .catch { _contactRequestState.value = CreateContactState.Error }.collect {
                    _contactRequestState.value = CreateContactState.Success
                }
        }

    }

    sealed class CreateContactState {
        object Init : CreateContactState()
        object Success : CreateContactState()
        object Loading : CreateContactState()
        object Error : CreateContactState()
    }
}