package com.example.xcritical.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcritical.R
import com.example.xcritical.databinding.FragmentSignalsBinding
import com.example.xcritical.instruments.AdapterGetMovies
import com.example.xcritical.viewmodel.ViewModelService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignalsFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(ViewModelService::class.java)}
    private var adapter: AdapterGetMovies? = null
    private lateinit var binding: FragmentSignalsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signals, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.getRequest()

        binding.buttonmovie.setOnClickListener {
            val listMovies = viewModel.getMoviesList()
            adapter = AdapterGetMovies(listMovies!!)
            binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
            binding.recyclerView.adapter = adapter
        }

        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                adapter?.updateFilteredList(viewModel.setMoviesListForFilter(s.toString()))
            }
        })
    }
}