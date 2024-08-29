package com.example.hathunter.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns

class LoginViewModel : ViewModel() {

    private val _isEmailValid = MutableLiveData<Boolean>()
    val isEmailValid: LiveData<Boolean> get() = _isEmailValid

    fun onEmailChanged(email: String) {
        _isEmailValid.value = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}