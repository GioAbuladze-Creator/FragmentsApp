package com.example.fragmentsapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn1 = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)
        val fragment1 = FirstFragment()
        val fragment2 = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment1)
            commit()
        }
        btn1.setOnClickListener {
            if (supportFragmentManager.findFragmentById(R.id.flFragment) !is FirstFragment) {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, fragment1)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        btn2.setOnClickListener {
            if (supportFragmentManager.findFragmentById(R.id.flFragment) !is SecondFragment) {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, fragment2)
                    addToBackStack(null)
                    commit()
                }
            }
        }

    }
}