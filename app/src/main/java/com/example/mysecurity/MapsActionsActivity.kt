package com.example.mysecurity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.ActivityMapsActionsBinding

class MapsActionsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMapsActionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps_actions)
        setSupportActionBar(binding.toolbar)
    }
}