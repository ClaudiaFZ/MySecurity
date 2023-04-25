package com.example.mysecurity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.ACTION_VIDEO_CAPTURE
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentGrabarBinding

class GrabarFragment : Fragment() {

    lateinit var binding: FragmentGrabarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grabar,
            container,
            false
        )
        binding.botonVideoAudio.setOnClickListener {
            //val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                //putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(locationForPhotos, targetFilename))
            //}
            // https://developer.android.com/guide/components/intents-common?hl=es-419#Camera

            startActivity(Intent(MediaStore.ACTION_VIDEO_CAPTURE))
        }
        binding.botonAudio.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_grabarFragment_to_grabarAudioFragment)
        }
        return binding.root
    }


}