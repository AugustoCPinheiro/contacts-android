package com.pinheiro.contacts.ui

import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.RemoteContactsRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ContactsViewModelTest {


    private val remoteRepository: RemoteContactsRepository = mockk(relaxed = true)

    private lateinit var viewModel: ContactsViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = ContactsViewModel(remoteRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun whenStart_shouldCallService() {
        verify(exactly = 1) {
            remoteRepository.getAllContacts()
        }
    }
}