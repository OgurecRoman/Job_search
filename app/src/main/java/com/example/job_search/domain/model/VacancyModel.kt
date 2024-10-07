package com.example.job_search.domain.model

data class VacancyModel(
    val title: String,
    val town: String,
    val company: String,
    val experience: String,
    val publishedDate: String,
    var isFavorite: Boolean = false,
    var lookingNumber: Int = 0,
)