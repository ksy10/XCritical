package com.example.xcritical.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.xcritical.R
import com.example.xcritical.activity.MusicActivity
import com.example.xcritical.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoreFragment : Fragment() {
    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_more, container, false)
        initMusic()
        return binding.root
    }

    private fun initMusic() {
        binding.imageMusic.setOnClickListener {
            val intent = Intent(this.context, MusicActivity::class.java)
            startActivity(intent)
        }
    }
}