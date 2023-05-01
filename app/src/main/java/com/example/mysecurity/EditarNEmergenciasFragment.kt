package com.example.mysecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentEditarNEmergenciasBinding
import com.example.mysecurity.databinding.FragmentRegistroBinding

class EditarNEmergenciasFragment : Fragment() {

    lateinit var binding: FragmentEditarNEmergenciasBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_editar_n_emergencias,
            container,
            false
        )
        binding.buttonConfirmarEdit.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_editarNEmergenciasFragment_to_principalFragment)
        }
        return binding.root
    }

}