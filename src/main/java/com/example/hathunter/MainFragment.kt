package com.example.hathunter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hathunter.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var jobsAdapter: JobsAdapter
    private val jobList: List<Job> = listOf() // Здесь должен быть ваш список вакансий из JSON

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация RecyclerView
        binding.jobsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        jobsAdapter = JobsAdapter(jobList)
        binding.jobsRecyclerView.adapter = jobsAdapter

        // Пример загрузки данных (замените на вашу логику)
        loadJobs()
    }

    private fun loadJobs() {
        // Здесь будет ваша логика загрузки данных
        // Например, из JSON или локальной базы данных
        // После загрузки вызовите jobsAdapter.updateData(loadedJobs)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}