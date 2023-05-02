package com.example.mysecurity

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentSonidoFlashBinding

class SonidoFlashFragment : Fragment() {
    lateinit var binding: FragmentSonidoFlashBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sonido_flash,
            container,
            false
        )
        binding.botonFlash.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_sonidoFlashFragment_to_linternaFragment)
        }
        binding.botonSonido.setOnClickListener {
            mediaPlayer = MediaPlayer()
            val audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
            mediaPlayer.setDataSource(audioUrl)
            mediaPlayer.prepare()
            mediaPlayer.start()
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}