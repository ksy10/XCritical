package com.example.xcritical.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcritical.R
import com.example.xcritical.instruments.AdapterCardInstrument
import com.example.xcritical.instruments.AdapterGetMovies
//import com.example.xcritical.instruments.AdapterGetMovies
import com.example.xcritical.viewmodel.ViewModelInstrument
import com.example.xcritical.viewmodel.ViewModelService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignalsFragment : Fragment() {

    private val buttonMovies by lazy { view?.findViewById<Button>(R.id.buttonmovie) }
    private val recyclerView by lazy { view?.findViewById<RecyclerView>(R.id.recyclerView) }
    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelService::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRequest()

        buttonMovies?.setOnClickListener {
            val listMovies = viewModel.getMoviesList()
            recyclerView?.layoutManager = LinearLayoutManager(this.context)
            recyclerView?.adapter = AdapterGetMovies(listMovies!!)
        }
    }
}