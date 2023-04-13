package com.example.mysecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.FragmentCompartirUbicacionBinding

class CompartirUbicacionFragment : Fragment() {
    private lateinit var adapter: ContactoAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCompartirUbicacionBinding>(
            inflater,
            R.layout.fragment_compartir_ubicacion,
            container,
            false
        )
        adapter = ContactoAdapter()
        var contactos: MutableList<ContactoEmergencia> = mutableListOf()
        adapter.data = SecurityAplication.usuario.contactosEmergencia
        binding.contactosEmergeciaRecyclerView.adapter = adapter

        return binding.root
    }

}