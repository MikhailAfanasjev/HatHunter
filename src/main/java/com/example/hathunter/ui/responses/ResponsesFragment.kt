package com.example.hathunter.ui.responses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hathunter.R

class ResponsesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Разметка для этого фрагмента
        return inflater.inflate(R.layout.fragment_responses, container, false)
    }

}