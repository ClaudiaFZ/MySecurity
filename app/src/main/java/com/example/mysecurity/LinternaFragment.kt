package com.example.mysecurity

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentLinternaBinding

class LinternaFragment : Fragment() {
    private lateinit var camManager: CameraManager
    lateinit var binding: FragmentLinternaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_linterna,
            container,
            false
        )

        camManager = context?.getSystemService(Context.CAMERA_SERVICE) as CameraManager

        val cameraId = camManager.cameraIdList[0] // usualmente la camara delantera esta en la posicion 0

        try{
            camManager.setTorchMode(cameraId, true)
        } catch (e: Exception){
            Toast.makeText(context, requireContext().getString(R.string.error_flash), Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(R.id.action_linternaFragment_to_principalFragment)
        }


        binding.botonPararFlash.setOnClickListener {
            camManager.setTorchMode(cameraId, false)
            view?.findNavController()?.navigate(R.id.action_linternaFragment_to_principalFragment)
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        val cameraId = camManager.cameraIdList[0]
        camManager.setTorchMode(cameraId, false)
    }

}