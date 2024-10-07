package com.example.job_search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.job_search.R
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
        val repository = VacancyRepository()
        val adapter = VacancyAdapter(repository.getVacancies())
        recycleViewVacancies.adapter = adapter


//        val recycleViewVacancies: RecyclerView = view.findViewById(R.id.recyclerViewVacancies)
//        val repository = VacancyRepository()
//
//        val receiver = object : BroadcastReceiver() {
//            override fun onReceive(context: Context, intent: Intent) {
//                if (intent.action == "MyServiceAction") {
//                    val value = intent.getStringExtra("key")
//                    recycleViewVacancies.setAdapter(VacancyAdapter(repository.getVacancies()))
//                }
//            }
//        }
//
//        val filter = IntentFilter("MyServiceAction")
//        activity?.registerReceiver(receiver, filter, Context.RECEIVER_NOT_EXPORTED)
//
//        val intent = Intent(activity, VacancyRepository::class.java)
//        activity?.startService(intent)

//        val adapter = VacancyAdapter(repository.getVacancies())
//        recycleViewVacancies.adapter = adapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomepageFragment().apply {
            }
    }
}