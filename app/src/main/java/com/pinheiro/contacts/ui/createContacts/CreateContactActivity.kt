package com.pinheiro.contacts.ui.createContacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pinheiro.contacts.databinding.ActivityCreateContactBinding
import com.pinheiro.contacts.models.Contact
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateContactActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreateContactBinding.inflate(layoutInflater) }
    private val viewModel: CreateContactViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListeners()
        setActions()
    }

    private fun setListeners() {
        lifecycleScope.launch {
            viewModel.contactsRequestState.collect {
                when (it) {
                    is CreateContactViewModel.CreateContactState.Success -> {
                        finish()
                    }
                    is CreateContactViewModel.CreateContactState.Error -> {

                    }
                    is CreateContactViewModel.CreateContactState.Loading -> {

                    }
                    is CreateContactViewModel.CreateContactState.Init -> {

                    }
                }
            }
        }

    }

    private fun setActions() {
        binding.saveButton.setOnClickListener {

            viewModel.saveContact(
                Contact(
                    0,
                    binding.editTextName.text.toString(),
                    binding.editTextNumber.text.toString()
                )
            )
        }
    }

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, CreateContactActivity::class.java)
    }
}