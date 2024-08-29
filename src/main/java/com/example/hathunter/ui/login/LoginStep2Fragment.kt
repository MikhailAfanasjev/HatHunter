package com.example.hathunter.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hathunter.R

class LoginStep2Fragment : Fragment(R.layout.fragment_login_step_2) {

    private lateinit var etCode1: EditText
    private lateinit var etCode2: EditText
    private lateinit var etCode3: EditText
    private lateinit var etCode4: EditText
    private lateinit var btnConfirm: View
    private lateinit var tvEmailSent: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etCode1 = view.findViewById(R.id.etCode1)
        etCode2 = view.findViewById(R.id.etCode2)
        etCode3 = view.findViewById(R.id.etCode3)
        etCode4 = view.findViewById(R.id.etCode4)
        btnConfirm = view.findViewById(R.id.btnConfirm)
        tvEmailSent = view.findViewById(R.id.tvEmailSent)

        // Получаем email, переданный из LoginFragment
        arguments?.let {
            val email = LoginStep2FragmentArgs.fromBundle(it).email
            tvEmailSent.text = getString(R.string.email_sent_text, email)
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkCodeCompletion()
                when {
                    s.isNullOrEmpty() -> return
                    etCode1.hasFocus() -> etCode2.requestFocus()
                    etCode2.hasFocus() -> etCode3.requestFocus()
                    etCode3.hasFocus() -> etCode4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        etCode1.addTextChangedListener(textWatcher)
        etCode2.addTextChangedListener(textWatcher)
        etCode3.addTextChangedListener(textWatcher)
        etCode4.addTextChangedListener(textWatcher)

        btnConfirm.setOnClickListener {
            // Здесь можно добавить логику проверки кода
            findNavController().navigate(R.id.action_loginFragment_to_loginStep2Fragment)
        }
    }

    private fun checkCodeCompletion() {
        btnConfirm.isEnabled = etCode1.text.isNotEmpty() &&
                etCode2.text.isNotEmpty() &&
                etCode3.text.isNotEmpty() &&
                etCode4.text.isNotEmpty()
    }
}