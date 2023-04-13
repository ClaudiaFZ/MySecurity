package com.example.mysecurity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentSetAtravesarZonaBinding

class SetAtravesarZonaFragment : Fragment() {
    lateinit var binding: FragmentSetAtravesarZonaBinding
    var minutos: Int = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_set_atravesar_zona,
            container,
            false
        )


        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val minutosTextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                minutos = s.toString().toInt()
            }
        }

        binding.minutos.addTextChangedListener(minutosTextWatcher)

        binding.botonConfirmar.setOnClickListener {
            it.findNavController().navigate(SetAtravesarZonaFragmentDirections.actionSetAtravesarZonaFragmentToAtravesandoZonaFragment(minutos))
        }

    }
}