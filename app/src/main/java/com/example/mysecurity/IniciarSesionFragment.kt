package com.example.mysecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentIniciarSesionBinding

class IniciarSesionFragment : Fragment() {

    lateinit var binding: FragmentIniciarSesionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_iniciar_sesion,
            container,
            false
        )



        return binding.root
    }

}