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
    private var mediaPlayer = MediaPlayer()
    private var playing = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sonido_flash,
            container,
            false
        )
        val audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
        mediaPlayer.setDataSource(audioUrl)
        mediaPlayer.prepare()

        binding.botonFlash.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_sonidoFlashFragment_to_linternaFragment)
        }
        binding.botonSonido.setOnClickListener {
            if (!playing){

                mediaPlayer.start()
                binding.botonSonido.text = requireContext().getString(R.string.pausa)
                playing = true
            }
            else{
                playing = false
                binding.botonSonido.text = requireContext().getString(R.string.sonido)
                mediaPlayer.release()
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}