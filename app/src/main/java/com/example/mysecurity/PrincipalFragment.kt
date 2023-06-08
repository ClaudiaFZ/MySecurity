package com.example.mysecurity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentPrincipalBinding
import com.example.mysecurity.databinding.FragmentSetAtravesarZonaBinding

class PrincipalFragment : Fragment() {
    lateinit var binding: FragmentPrincipalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_principal,
            container,
            false
        )

        binding.botonAtravesarZona.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_principalFragment_to_setAtravesarZonaFragment)

        }

        binding.botonMapa.setOnClickListener {
            val intent = Intent(activity, MapsActivity::class.java)
            requireActivity().startActivity(intent)
        }

        binding.botonAyuda.setOnClickListener {  view ->
            view.findNavController().navigate(R.id.action_principalFragment_to_ayudaFragment)
        }

        binding.botonGrabar.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_principalFragment_to_grabarFragment)

        }

        binding.botonSonidoFlash.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_principalFragment_to_sonidoFlashFragment)

        }

        binding.botonCompartirUbicacion.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_principalFragment_to_compartirUbicacionFragment)

        }

        return binding.root
    }

}