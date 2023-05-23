package com.figueroa.test1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.figueroa.test1.R
import com.figueroa.test1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}