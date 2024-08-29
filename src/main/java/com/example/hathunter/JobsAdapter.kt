package com.example.hathunter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hathunter.databinding.ItemJobBinding

class JobsAdapter(private var jobs: List<Job>) : RecyclerView.Adapter<JobsAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobs[position]
        holder.bind(job)
    }

    override fun getItemCount(): Int = jobs.size

    fun updateData(newJobs: List<Job>) {
        jobs = newJobs
        notifyDataSetChanged()
    }

    inner class JobViewHolder(private val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            binding.titleTextView.text = job.title
            binding.companyTextView.text = job.company
            binding.locationTextView.text = job.location

            // Добавьте другие элементы и логику
        }
    }
}