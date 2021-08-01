package com.example.xcritical.customview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.xcritical.R
import com.example.xcritical.databinding.FragmentCustomDialogBinding

class FragmentCustomDialog : DialogFragment() {

    private lateinit var binding: FragmentCustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_custom_dialog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setCancelable(false)
        binding.buttonOk.setOnClickListener {
            //invoke(onClick(::onSendToast))
            dismiss()
        }
    }

    private fun onClick(mes: () -> Unit) {
        mes()
    }
}