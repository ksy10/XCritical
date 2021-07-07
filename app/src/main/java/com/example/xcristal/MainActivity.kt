package com.example.xcristal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val text_error_email by lazy { findViewById<TextView>(R.id.text_error_email) }
    private  val editText_email by lazy { findViewById<EditText>(R.id.editText_email) }
    private val editText_password by lazy { findViewById<EditText>(R.id.editText_password) }
    private val text_error_password by lazy { findViewById<TextView>(R.id.text_error_password) }
    private val button_login by lazy { findViewById<Button>(R.id.button_login) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_login.setOnClickListener{
            if (editText_email.text.toString().isEmpty()) {
                text_error_email.visibility = View.VISIBLE
            }
            if (editText_password.text.toString().isEmpty()) {
                text_error_password.visibility = View.VISIBLE
            }
        }

        editText_email.addTextChangedListener(object:TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text_error_email.visibility = View.INVISIBLE
            }
        })

        editText_password.addTextChangedListener(object:TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text_error_password.visibility = View.INVISIBLE
            }
        })
    }
}