package com.example.xcritical.fragment

import android.gesture.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.xcritical.R
import com.example.xcritical.databinding.FragmentInstrumentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InstrumentFragment : Fragment(), GestureOverlayView.OnGesturePerformedListener {
    private lateinit var binding: FragmentInstrumentBinding
    private var _library: GestureLibrary?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instrument, container, false)
        initLayout()
        return binding.root
    }

    private fun initLayout() {
        binding.gesture.addOnGesturePerformedListener(this)
        _library = GestureLibraries.fromRawResource(this.context, R.raw.gestures)
    }

    override fun onGesturePerformed(overlay: GestureOverlayView?, gesture: Gesture?) {
        _library?.let { arrayListOf<ArrayList<Prediction>>(it.recognize(gesture)) }
    }
}