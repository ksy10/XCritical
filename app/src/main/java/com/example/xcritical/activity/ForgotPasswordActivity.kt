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
import androidx.lifecycle.ViewModelProvider
import com.example.xcritical.R
import com.example.xcritical.instruments.ViewModel_Instrument


class ForgotPasswordActivity : AppCompatActivity() {

    private val textErrorEmail by lazy { findViewById<TextView>(R.id.textErrorEmail) }
    private  val editTextEmail by lazy { findViewById<EditText>(R.id.editTextEmail) }
    private val buttonChange by lazy { findViewById<Button>(R.id.buttonChange) }

    private lateinit var viewModel: ViewModel_Instrument

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        viewModel = ViewModelProvider(this).get(ViewModel_Instrument::class.java)

        initListener()

        buttonChange.setOnClickListener {
            viewModel.email = editTextEmail.text.toString()

            if(!viewModel.validationEmail()){
                textErrorEmail.visibility = View.VISIBLE
            }
        }
    }

    private fun initListener() {
        editTextEmail.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textErrorEmail.visibility = View.INVISIBLE
                viewModel.validationEmail()
            }
        })
    }

    fun backLogin(view: View) {
        val intent = Intent(this, LogActivity::class.java)
        startActivity(intent)
    }
}

