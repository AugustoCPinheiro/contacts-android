package com.pinheiro.contacts.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.pinheiro.contacts.databinding.ActivityCreateContactBinding

class CreateContactActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreateContactBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }

    companion object{
        fun getLaunchIntent(context: Context) = Intent(context, CreateContactActivity::class.java)
    }
}