package com.example.hathunter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hathunter.databinding.FragmentMatchedJobsBinding

class MatchedJobsFragment : Fragment() {

    private var _binding: FragmentMatchedJobsBinding? = null
    private val binding get() = _binding!!

    private lateinit var matchedJobsAdapter: JobsAdapter
    private val matchedJobList: List<Job> = listOf() // Здесь должен быть ваш список вакансий по соответствию

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMatchedJobsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация RecyclerView
        binding.matchedJobsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        matchedJobsAdapter = JobsAdapter(matchedJobList)
        binding.matchedJobsRecyclerView.adapter = matchedJobsAdapter

        // Пример загрузки данных
        loadMatchedJobs()
    }

    private fun loadMatchedJobs() {
        // Замените на вашу логику загрузки данных по соответствию
        // Например, из локальной базы данных или сервера
        // После загрузки вызовите matchedJobsAdapter.updateData(loadedMatchedJobs)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}