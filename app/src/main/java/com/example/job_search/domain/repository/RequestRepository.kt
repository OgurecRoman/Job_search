package com.example.job_search.domain.repository

import android.util.Log
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL


class RequestRepository: Runnable {
    private var jsonObject = JSONObject()

    override fun run() {
        val url =
            URL("https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
        val urlConnection = url.openConnection() as HttpURLConnection
        Log.d("RRR", "я здесь1")
        urlConnection.requestMethod = "GET"
        Log.d("RRR", "я здесь2")
        val inputStream = urlConnection.inputStream
        Log.d("RRR", "я здесь3")
        val response = inputStream.bufferedReader().use { it.readText() }
        Log.d("RRR", "я здесь4")
        jsonObject = JSONObject(response)
    }

    fun getObject() : JSONObject {
        return jsonObject
    }
}