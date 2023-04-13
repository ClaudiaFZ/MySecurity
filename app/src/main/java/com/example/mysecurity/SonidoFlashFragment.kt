package com.example.mysecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.FragmentSonidoFlashBinding

class SonidoFlashFragment : Fragment() {
    lateinit var binding: FragmentSonidoFlashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sonido_flash,
            container,
            false
        )
        return binding.root
    }

}