package com.pinheiro.contacts.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pinheiro.contacts.databinding.ContactsViewHolderBinding
import com.pinheiro.contacts.models.Contact

class ContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding by lazy { ContactsViewHolderBinding.bind(view) }
    fun bind(contact: Contact) {
        binding.textViewName.text = contact.name
    }
}