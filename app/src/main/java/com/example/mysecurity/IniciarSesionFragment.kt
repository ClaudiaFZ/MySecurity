package com.example.mysecurity

import android.content.Intent
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
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_iniciar_sesion,
            container,
            false
        )
        //activity.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        binding.buttonSignUp.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            requireActivity().startActivity(intent)
        }

        binding.buttonCrearCuenta.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_iniciarSesionFragment_to_registroFragment)
        }

        return binding.root
    }

}