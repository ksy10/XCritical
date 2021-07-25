package com.example.xcritical.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.R
import com.example.xcritical.viewmodel.ViewModelId
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelId::class.java)}
    private val textId by lazy { view?.findViewById<TextView>(R.id.id) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardId: Int = arguments?.getInt("id")!!
        init(cardId)
    }

    private fun init(id: Int) {
        val model = viewModel.getId(id)
        textId?.text = model.id.toString()
    }
}