package com.example.job_search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_view: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(this, R.id.my_nav_graph)

        setupWithNavController(nav_view, navController)
    }
}