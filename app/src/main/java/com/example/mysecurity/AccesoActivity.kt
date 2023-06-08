package com.example.mysecurity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.ActivityAccesoBinding

class AccesoActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccesoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acceso)
    }
}