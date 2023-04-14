package com.example.mysecurity

import android.Manifest.permission.CALL_PHONE
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentAyudaBinding

class AyudaFragment : Fragment() {
    lateinit var binding: FragmentAyudaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_ayuda,
            container,
            false
        )
        binding.botonCancelar.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_ayudaFragment_to_principalFragment)
        }

        Thread.sleep(5_000)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED ->{
                    startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:637093883")))

                }
            }

        }
        else{
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:637093883")))
        }


        return binding.root
    }


}