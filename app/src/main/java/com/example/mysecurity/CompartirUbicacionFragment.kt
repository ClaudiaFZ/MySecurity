package com.example.mysecurity

import android.app.AlertDialog
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
    ): View {
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
            alertDialog.setTitle(requireContext().getString(R.string.compartir_ubicacion))
            alertDialog.setMessage(requireContext().getString(R.string.ubi_correct))
            alertDialog.setPositiveButton(requireContext().getString(R.string.aceptar)) { _, _ ->
            }

            alertDialog.show()
        }

        return binding.root
    }

}