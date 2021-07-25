package com.example.xcritical.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.instruments.AdapterCardInstrument
import com.example.xcritical.R
import com.example.xcritical.viewmodel.ViewModelInstrument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalletFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelInstrument::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler)
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
        recyclerView?.adapter = AdapterCardInstrument(viewModel.getList()) { id -> cardItemClicked(id)
        }
    }

    private fun cardItemClicked(id: Int) {
        val bundle = bundleOf("id" to "Card id $id")
        view?.findNavController()?.navigate(R.id.action_walletFragment_to_informationFragment, bundle)
    }
}