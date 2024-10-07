package com.example.job_search.domain.repository

import com.example.job_search.domain.model.VacancyModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
    fun getCourse(): Call<VacancyModel?>?
}