package com.pinheiro.contacts.ui.contacts

import com.pinheiro.contacts.models.Contact

sealed class ContactsState {
    class Success(val contacts: List<Contact>) : ContactsState()
    object Loading : ContactsState()
    object Initial : ContactsState()
    object Error : ContactsState()
}
