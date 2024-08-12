package com.example.app_splash

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var edtUsername: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var edtContact: TextInputEditText
    private lateinit var btnReset: Button
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUsername = findViewById(R.id.edt1)
        edtPassword = findViewById(R.id.edt2)
        edtContact = findViewById(R.id.edt3)
        btnReset = findViewById(R.id.button3)
        btnSubmit = findViewById(R.id.button4)

        btnReset.setOnClickListener {
            resetFields()
        }

        btnSubmit.setOnClickListener {
            if (validateInputs()) {
                submitRegistration()
            }
        }
    }

    private fun resetFields() {
        edtUsername.text?.clear()
        edtPassword.text?.clear()
        edtContact.text?.clear()
    }

    private fun validateInputs(): Boolean {
        val username = edtUsername.text.toString().trim()
        val password = edtPassword.text.toString().trim()
        val contact = edtContact.text.toString().trim()

        if (TextUtils.isEmpty(username)) {
            edtUsername.error = "Username is required"
            edtUsername.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(password)) {
            edtPassword.error = "Password is required"
            edtPassword.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(contact)) {
            edtContact.error = "Contact is required"
            edtContact.requestFocus()
            return false
        }

        return true
    }

    private fun submitRegistration() {
        val username = edtUsername.text.toString().trim()
        val password = edtPassword.text.toString().trim()
        val contact = edtContact.text.toString().trim()


        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
        resetFields()
    }
}
