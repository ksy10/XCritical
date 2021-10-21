package com.example.xcritical.fragment


import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
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
    private lateinit var binding: FragmentWalletBinding

    companion object {
        var path = Path()
        var brush = Paint()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, container, false)
        initClear()
        return binding.root
    }

    private fun initClear() {
        binding.buttonClear.setOnClickListener {
            binding.paint.clear()
        }
    }
}