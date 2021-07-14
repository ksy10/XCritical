package com.example.xcritical.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.instruments.AdapterInstrument
import com.example.xcritical.instruments.CardInstrument
import com.example.xcritical.R


class WalletFragment : Fragment() {

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
        recyclerView?.adapter = AdapterInstrument(generateList(20))
    }

    private fun generateList(size:Int):ArrayList<CardInstrument> {
        val list = ArrayList<CardInstrument>()
        for (i in 0 until size) {
            val draw = when(i%2) {
                0-> R.drawable.ic_default_icon_currency
                else -> R.drawable.ic_star
            }
            val item = CardInstrument("AUD","/","JPY","73,5670","/","73,5940","0,03%")
            list += item
        }
        return list
    }
}