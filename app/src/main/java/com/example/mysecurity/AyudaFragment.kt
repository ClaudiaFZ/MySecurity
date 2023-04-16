package com.example.mysecurity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
        //startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:637093883")))


        val permission = ContextCompat.checkSelfPermission(requireContext().applicationContext,
            Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // ACTION_CALL
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:637093883")))

        }



        return binding.root
    }


}