package com.example.job_search.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.job_search.R
import com.example.job_search.domain.model.VacancyModel

class VacancyAdapter(private val data: ArrayList<VacancyModel>) :
    RecyclerView.Adapter<VacancyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val town: TextView
        val company: TextView
        val experience: TextView
        val date: TextView
        val lookCount: TextView

        init {
            title = view.findViewById(R.id.title)
            town = view.findViewById(R.id.town)
            company = view.findViewById(R.id.company)
            experience = view.findViewById(R.id.experience)
            date = view.findViewById(R.id.data)
            lookCount = view.findViewById(R.id.lookCount)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.vacancy_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Установка данных
        viewHolder.title.text = data[position].title
        viewHolder.town.text = data[position].town
        viewHolder.company.text = data[position].company
        viewHolder.experience.text = data[position].experience
        viewHolder.date.text = data[position].publishedDate
    }

    override fun getItemCount() = data.size
}