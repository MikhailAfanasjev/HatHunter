package com.example.hathunter

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hathunter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Настраиваем взаимодействие между BottomNavigationView и NavController
        navView.setupWithNavController(navController)

        // Дополнительно можно установить слушателя на изменение фрагментов
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_search -> {
                    // Логика при переходе на экран поиска
                }
                R.id.navigation_favorites -> {
                    // Логика при переходе на экран избранного
                }
                R.id.navigation_responses -> {
                    // Логика при переходе на экран откликов
                }
                R.id.navigation_messages -> {
                    // Логика при переходе на экран сообщений
                }
                R.id.navigation_profile -> {
                    // Логика при переходе на экран профиля
                }
            }
        }
    }
}