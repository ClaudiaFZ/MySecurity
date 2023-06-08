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
import com.example.mysecurity.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    lateinit var binding: FragmentRegistroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registro,
            container,
            false
        )

        binding.buttonSignUp.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            requireActivity().startActivity(intent)
        }

        return binding.root
    }

}