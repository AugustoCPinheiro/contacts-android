package com.pinheiro.contacts.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pinheiro.contacts.ui.adapters.ContactsAdapter
import com.pinheiro.contacts.databinding.ActivityContactsBinding
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

        binding.floatingButton.setOnClickListener {
            //TODO add action
        }
        bindListeners(adapter)
    }

    private fun bindListeners(adapter: ContactsAdapter) {
        lifecycleScope.launch {
            viewModel.contacts.collect {
                adapter.submitList(it)
            }
        }
    }
}