package com.example.mysecurity

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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
        adapter.data = SecurityAplication.usuario.contactosEmergencia
        binding.contactosEmergeciaRecyclerView.adapter = adapter

        binding.botonCompartir.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.setTitle("Compartir ubicación")
            alertDialog.setMessage("La ubicación se ha compartido correctamente")
            alertDialog.setPositiveButton("Aceptar") { dialog, which ->
            }

            alertDialog.show()
        }

        return binding.root
    }

}