package com.pinheiro.contacts.ui.createContacts

sealed class CreateContactsState {
    object Init : CreateContactsState()
    object Success : CreateContactsState()
    object Loading : CreateContactsState()
    object Error : CreateContactsState()
}