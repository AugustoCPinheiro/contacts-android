package com.pinheiro.contacts

import android.app.Application
import com.pinheiro.contacts.di.contactsModule
import org.koin.core.context.startKoin

class ContactsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(contactsModule)
        }
    }
}