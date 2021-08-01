package com.example.xcritical.fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.instruments.AdapterCardInstrument
import com.example.xcritical.R
import com.example.xcritical.databinding.FragmentSignalsBinding
import com.example.xcritical.databinding.FragmentWalletBinding
import com.example.xcritical.instruments.AdapterGetMovies
import com.example.xcritical.instruments.SwipeToDelete
import com.example.xcritical.viewmodel.ViewModelInstrument
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalletFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelInstrument::class.java)}
    private var adapterCard: AdapterCardInstrument? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editSearch = getView()?.findViewById<EditText>(R.id.editSearch)
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler)
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
        adapterCard = AdapterCardInstrument(viewModel.getList()) { id -> cardItemClicked(id) }
        recyclerView?.adapter = adapterCard

        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapterCard!!))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        editSearch?.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                adapterCard?.filter?.filter(s)
            }
        })
    }

    private fun cardItemClicked(id: Int) {
        val bundle = bundleOf("id" to id)
        view?.findNavController()?.navigate(R.id.action_walletFragment_to_informationFragment, bundle)
    }
}