package com.example.xcritical.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.instruments.AdapterInstrument
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.R
import com.example.xcritical.instruments.ViewModelInstrument


class WalletFragment : Fragment() {

    private lateinit var viewModel: ViewModelInstrument

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelInstrument::class.java)

        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler)
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
        recyclerView?.adapter = AdapterInstrument(viewModel.generateList(20)) { Id -> cardItemClicked(Id)
        }
    }

    fun cardItemClicked(Id: Int) {
        val bundle = bundleOf("Id" to "Card id $Id")
        view?.findNavController()?.navigate(R.id.action_walletFragment_to_informationFragment, bundle)
    }
}