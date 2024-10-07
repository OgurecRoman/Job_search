package com.example.job_search.domain.repository

import android.util.Log
import com.example.job_search.domain.model.VacancyModel
import org.json.JSONException
import org.json.JSONObject


class VacancyRepository {
    private val listVacancies = arrayListOf<VacancyModel>()

    fun getVacancies(): ArrayList<VacancyModel> {

        val requestRepository = RequestRepository()
        val thread: Thread = Thread(requestRepository)
        thread.start()
        thread.join()
        val data = requestRepository.getObject()

        val vacancies = data.getJSONArray("vacancies")
        Log.d("RRR", "" + vacancies)

        for (i in (0..<vacancies.length())) {
            val elem = vacancies[i] as JSONObject
            var look_num: Int
            try {
                look_num = elem.getInt("lookingNumber")
            }catch (e: JSONException){
                look_num = 0
            }
            val vacancy = VacancyModel(
                title = elem.getString("title"),
                town = elem.getJSONObject("address").getString("town"),
                company = elem.getString("company"),
                experience = elem.getJSONObject("experience").getString("previewText"),
                publishedDate = elem.getString("publishedDate"),
                isFavorite = elem.getBoolean("isFavorite"),
                lookingNumber = look_num

            )
            Log.d("RRR", "новый объект " + vacancy)
            listVacancies.add(vacancy)}

        return listVacancies
    }

    fun setLike(id: Int) {
        val vacancy = listVacancies[id]
        vacancy.isFavorite = !vacancy.isFavorite
    }
}