package com.example.hathunter.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.hathunter.R
import com.example.hathunter.databinding.FragmentLoginBinding
import androidx.navigation.fragment.findNavController
//import com.example.hathunter.ui.login.LoginFragmentDirections

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var etEmail: EditText
    private lateinit var btnContinue: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etEmail = view.findViewById(R.id.etEmail)
        btnContinue = view.findViewById(R.id.btnContinue)

        etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnContinue.isEnabled = isValidEmail(s.toString())
                if (btnContinue.isEnabled) {
                    btnContinue.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.enabled_button))
                } else {
                    btnContinue.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.disabled_button))
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        btnContinue.setOnClickListener {
            val email = etEmail.text.toString()
            if (isValidEmail(email)) {
                // Убедитесь, что этот метод импортирован и используется в фрагменте
                val action = LoginFragmentDirections.actionLoginFragmentToLoginStep2Fragment(email)
                findNavController().navigate(action)
            } else {
                etEmail.error = getString(R.string.invalid_email)
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}