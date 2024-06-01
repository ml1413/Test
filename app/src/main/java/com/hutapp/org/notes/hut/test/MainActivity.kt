package com.hutapp.org.notes.hut.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hutapp.org.notes.hut.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}