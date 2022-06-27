package com.pinheiro.contacts.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pinheiro.contacts.databinding.BottomSheetErrorBinding

class ErrorBottomSheet : BottomSheetDialogFragment() {
    private var _binding: BottomSheetErrorBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetErrorBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewDesc.text = arguments?.getString(KEY_DESCRIPTION)
        binding.buttonRetry.setOnClickListener {

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(description: String): ErrorBottomSheet {
            val extras = Bundle().apply { putString(KEY_DESCRIPTION, description) }
            return ErrorBottomSheet().apply { arguments = extras }
        }

        private const val KEY_DESCRIPTION = "description"
    }
}