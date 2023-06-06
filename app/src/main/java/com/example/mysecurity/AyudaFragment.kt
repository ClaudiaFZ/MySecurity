package com.example.mysecurity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentAyudaBinding
import java.util.concurrent.TimeUnit


class AyudaFragment : Fragment() {
    lateinit var binding: FragmentAyudaBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_ayuda,
            container,
            false
        )
        binding.botonCancelar.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_ayudaFragment_to_principalFragment)
        }

        //Thread.sleep(5_000)
        //startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:637093883")))


        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                Manifest.permission.CALL_PHONE)) {
            //El usuario ya ha rechazado el permiso anteriormente, debemos informarle que vaya a ajustes.
        } else {
            //El usuario nunca ha aceptado ni rechazado, así que le pedimos que acepte el permiso.
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.CALL_PHONE),
                0)
            try {
                TimeUnit.SECONDS.sleep(5)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:637093883")))

        }

        return binding.root
    }



}