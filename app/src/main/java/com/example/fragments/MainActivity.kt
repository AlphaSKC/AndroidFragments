package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.itemfragment1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontent, PrimerFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack("replacement")
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemfragment2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontent, SegundoFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack("replacement")
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemfragment3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontent, TercerFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack("replacement")
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navmenu)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontent, PrimerFragment())
            .setReorderingAllowed(true)
            .addToBackStack("replacement")
            .commit()


    }
}