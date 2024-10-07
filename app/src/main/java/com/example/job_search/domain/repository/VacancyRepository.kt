package com.example.job_search.domain.repository

import android.util.Log
import com.example.job_search.domain.model.VacancyModel
import org.json.JSONArray
import org.json.JSONObject

class VacancyRepository {
    private val listVacancies = arrayListOf<VacancyModel>()

    fun getVacancies(): ArrayList<VacancyModel> {
        val requestRepository = RequestRepository()
        val data = requestRepository.getRequest()

        data?.let { data ->
            val vacancies: JSONArray = data.getJSONArray("vacancies")

            for (i in (0..<vacancies.length())) {
                val elem = vacancies[i] as JSONObject
                val vacancy = VacancyModel(
                    title = elem.getString("title"),
                    town = elem.getJSONObject("adress").getString("town"),
                    company = elem.getString("company"),
                    experience = elem.getJSONObject("experience").getString("previewText"),
                    publishedDate = elem.getString("publishedDate"),
                    isFavorite = elem.getBoolean("isFavorite"),
                    lookingNumber = elem.getInt("lookingNumber")
                )
                Log.d("RRR", "новый объект " + vacancy)
                listVacancies.add(vacancy)
            }
        }

        return listVacancies
    }

    fun setLike(id: Int) {
        val vacancy = listVacancies[id]
        vacancy.isFavorite = !vacancy.isFavorite
    }
}