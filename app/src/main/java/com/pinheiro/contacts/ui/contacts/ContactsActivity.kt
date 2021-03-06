package com.pinheiro.contacts.ui.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pinheiro.contacts.ui.adapters.ContactsAdapter
import com.pinheiro.contacts.databinding.ActivityContactsBinding
import com.pinheiro.contacts.ui.components.ErrorBottomSheet
import com.pinheiro.contacts.ui.createContacts.CreateContactActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsActivity : AppCompatActivity() {

    private val viewModel: ContactsViewModel by viewModel()

    private val binding: ActivityContactsBinding by lazy {
        ActivityContactsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = ContactsAdapter()

        binding.contactsRecyclerView.adapter = adapter

        setActions()
        bindListeners(adapter)
    }

    private fun bindListeners(adapter: ContactsAdapter) {
        lifecycleScope.launch {
            viewModel.contactsState.collect {
                when (it) {
                    is ContactsState.Success -> {
                        adapter.submitList(it.contacts)
                    }
                    is ContactsState.Loading -> {
                        //TODO implement loading
                    }
                    is ContactsState.Error -> {
                        //TODO implement error handling
                    }
                    else -> {}
                }

            }
        }
    }

    private fun setActions() {
        binding.floatingButton.setOnClickListener {
            startActivity(CreateContactActivity.getLaunchIntent(this))
        }
    }
}