package com.pinheiro.contacts.repository

import com.pinheiro.contacts.models.Contact
import com.pinheiro.contacts.repository.api.ContactsApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals

class RemoteContactsRepositoryTest {

    private val contactsApiMock = mockk<ContactsApi>(relaxed = true)

    private lateinit var remoteContactsRepository: RemoteContactsRepository

    @Before
    fun setup() {
        remoteContactsRepository = RemoteContactsRepository(contactsApiMock)
    }

    @Test
    fun getAllContacts_calls_correctApi() {
        coEvery { contactsApiMock.getContacts() } returns Response.success(mockContactList)
        runBlocking {
            val result = remoteContactsRepository.getAllContacts().first()
            coVerify(exactly = 1) {
                contactsApiMock.getContacts()
            }
            assertEquals(mockContactList, result)
        }
    }

    private companion object {
        val mockContactList = listOf(Contact(0, "Teste", "Teste"))
    }
}