package com.example.skeleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skeleton.databinding.ActivityMainBinding
import com.example.skeleton.presentation.PhotosFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.container.id, PhotosFragment())
            .commit()
    }
}