package com.example.job_search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.job_search.R
import com.example.job_search.domain.model.VacancyModel
import com.example.job_search.domain.repository.VacancyRepository
import com.example.job_search.presentation.adapters.VacancyAdapter

class HomepageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_homepage, container, false)

        val recycleViewVacancies: RecyclerView = view.findViewById(R.id.recyclerViewVacancies)
        val butMore: Button = view.findViewById(R.id.butMore)

        val repository = VacancyRepository()

        val vacancies = if (repository.getList().isEmpty()) {
            repository.getVacancies()
        } else {
            repository.getList()
        }

        butMore.setText("Еще " + (vacancies.size - 3) + " вакансий")
        var adapter = VacancyAdapter(vacancies.take(3) as ArrayList<VacancyModel>)
        recycleViewVacancies.adapter = adapter

        butMore.setOnClickListener {
            adapter = VacancyAdapter(vacancies)
            recycleViewVacancies.adapter = adapter
            butMore.setVisibility(View.GONE)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomepageFragment().apply {
            }
    }
}