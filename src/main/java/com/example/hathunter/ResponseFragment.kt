package com.example.hathunter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.hathunter.databinding.FragmentResponseBinding

class ResponseFragment : DialogFragment() {

    private var _binding: FragmentResponseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResponseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_Dialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Обработка нажатия на кнопку "Откликнуться"
        binding.btnRespond.setOnClickListener {
            val coverLetter = binding.etCoverLetter.text.toString()
            if (coverLetter.isNotEmpty()) {
                // Логика отклика на вакансию
                // Например, отправка данных на сервер или локальное сохранение
                Toast.makeText(context, "Ваш отклик отправлен!", Toast.LENGTH_SHORT).show()
                dismiss()
            } else {
                Toast.makeText(context, "Пожалуйста, введите сопроводительное письмо.", Toast.LENGTH_SHORT).show()
            }
        }

        // Обработка нажатия на кнопку "Отмена"
        binding.btnCancel.setOnClickListener {
            dismiss() // Закрытие диалогового окна
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}