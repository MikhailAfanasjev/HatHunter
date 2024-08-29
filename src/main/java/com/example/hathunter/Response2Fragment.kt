package com.example.hathunter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hathunter.databinding.FragmentResponse2Binding

class Response2Fragment : Fragment() {

    private var _binding: FragmentResponse2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResponse2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение аргументов, если они были переданы
        val userName = arguments?.getString("userName") ?: "Имя пользователя"
        val userEmail = arguments?.getString("userEmail") ?: "Электронная почта"

        binding.tvUserName.text = userName
        binding.tvUserEmail.text = userEmail

        // Обработка нажатия на кнопку "Отправить отклик"
        binding.btnSubmitResponse.setOnClickListener {
            val coverLetter = binding.etCoverLetter.text.toString()
            if (coverLetter.isNotEmpty()) {
                // Логика отправки отклика на сервер или сохранение данных
                Toast.makeText(context, "Отклик успешно отправлен!", Toast.LENGTH_SHORT).show()
                activity?.supportFragmentManager?.popBackStack()
            } else {
                Toast.makeText(context, "Пожалуйста, введите сопроводительное письмо.", Toast.LENGTH_SHORT).show()
            }
        }

        // Обработка нажатия на кнопку "Отмена"
        binding.btnCancelResponse.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}