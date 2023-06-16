package com.example.mysecurity

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mysecurity.databinding.FragmentLinternaBinding
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.CameraX
import androidx.camera.core.TorchState
import androidx.navigation.findNavController

class LinternaFragment : Fragment() {
    private lateinit var camManager: CameraManager

    //no va ahora
    //val camera = CameraX.getCameraProvider(this).bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA)

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
            Toast.makeText(context, "The device doesn't have flash unit", Toast.LENGTH_SHORT)
            //view?.findNavController()?.navigate(R.id.action_linternaFragment_to_principalFragment)
        }


        binding.botonPararFlash.setOnClickListener {
            camManager.setTorchMode(cameraId, false)
            //view?.findNavController()?.navigate(R.id.action_linternaFragment_to_principalFragment)
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        //camManager!!.setTorchMode(cameraId, false)
    }

}