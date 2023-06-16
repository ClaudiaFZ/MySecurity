package com.example.mysecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.FragmentAnadirMarcadorBinding

class AnadirMarcadorFragment : Fragment() {
    lateinit var binding: FragmentAnadirMarcadorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_anadir_marcador,
            container,
            false
        )

        val options = listOf("Zona peligrosa", "Zona oscura", "incidente puntual")
        
        val adapter = context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                options
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.opcionesSpinner.adapter = adapter

        binding.anadir.setOnClickListener {

        }
        return binding.root
    }


}