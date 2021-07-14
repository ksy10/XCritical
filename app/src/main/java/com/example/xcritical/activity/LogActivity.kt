package com.example.xcritical.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.R
import com.example.xcritical.instruments.ViewModel_Instrument


class LogActivity : AppCompatActivity() {

    private val textErrorEmail by lazy { findViewById<TextView>(R.id.textErrorEmail) }
    private val editTextEmail by lazy { findViewById<EditText>(R.id.editTextEmail) }
    private val editTextPassword by lazy { findViewById<EditText>(R.id.editTextPassword) }
    private val textErrorPassword by lazy { findViewById<TextView>(R.id.textErrorPassword) }
    private val buttonLogin by lazy { findViewById<Button>(R.id.buttonLogin) }

    private lateinit var viewModel: ViewModel_Instrument

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        viewModel = ViewModelProvider(this).get(ViewModel_Instrument::class.java)

        initListener()

        buttonLogin.setOnClickListener {
            viewModel.email = editTextEmail.text.toString()
            viewModel.password = editTextPassword.text.toString()

            if(viewModel.validationEmail()) {
                textErrorEmail.visibility = View.VISIBLE
            }
            else  {
                textErrorEmail.visibility = View.INVISIBLE
            }
            if (viewModel.validationPassword()) {
                textErrorPassword.visibility = View.VISIBLE
            }
            else{
                textErrorPassword.visibility = View.INVISIBLE
            }

            if (!textErrorEmail.isVisible || !textErrorPassword.isVisible) {
                mainScreen()
            }
        }
    }

    private fun initListener() {
        editTextEmail.addTextChangedListener(object:TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textErrorEmail.visibility = View.INVISIBLE
            }
        })

        editTextPassword.addTextChangedListener(object:TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textErrorPassword.visibility = View.INVISIBLE
            }
        })
    }

    fun forgotPassword(view: View) {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    fun mainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}