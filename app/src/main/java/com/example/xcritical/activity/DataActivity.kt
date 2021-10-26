package com.example.xcritical.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcritical.R
import com.example.xcritical.databinding.ActivityDataBinding
import com.example.xcritical.instruments.UserAdapter
import com.example.xcritical.viewmodel.DataViewModel
import com.example.xcritical.viewmodel.ViewModelService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DataActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(DataViewModel::class.java) }
    private var adapter: UserAdapter? = null
    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_data)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initList()
        initButton()
    }

    private fun initButton() {
        binding.buttonmovie.setOnClickListener {
            viewModel.insertUser()
        }
    }

    fun initList() {
        //binding.buttonSee.setOnClickListener {
            adapter = viewModel.getUsers()?.let { it1 -> UserAdapter(it1) }
            binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            binding.recyclerView.adapter = adapter
        //}
    }
}