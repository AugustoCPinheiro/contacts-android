package com.pinheiro.contacts.di

import com.pinheiro.contacts.repository.RemoteContactsRepository
import com.pinheiro.contacts.repository.api.ContactsApi
import com.pinheiro.contacts.ui.ContactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val contactsModule = module {
    single { ContactsApi.create() }
    single { RemoteContactsRepository(get()) }
    viewModel { ContactsViewModel(get<RemoteContactsRepository>()) }
}