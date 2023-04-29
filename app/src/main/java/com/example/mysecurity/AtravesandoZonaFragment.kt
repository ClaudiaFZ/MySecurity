package com.example.mysecurity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.FragmentAtravesandoZonaBinding
import java.util.*

class AtravesandoZonaFragment : Fragment() {

    private var isTimerRunning = false
    private var timeLeftInMillis = 60000  // tiempo predeterminado: 1 minuto
    private lateinit var countDownTimer: CountDownTimer
    lateinit var binding:FragmentAtravesandoZonaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_atravesando_zona,
            container,
            false
        )
        binding.startButton.setOnClickListener {
            if (isTimerRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        }
        timeLeftInMillis *= AtravesandoZonaFragmentArgs.fromBundle(requireArguments()).minutos
        updateCountDownText(binding.timerTextview)
        startTimer()
        return binding.root
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished.toInt()
                updateCountDownText(binding.timerTextview)
            }

            override fun onFinish() {
                isTimerRunning = false

                if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                        Manifest.permission.CALL_PHONE)) {
                    //El usuario ya ha rechazado el permiso anteriormente, debemos informarle que vaya a ajustes.
                } else {
                    //El usuario nunca ha aceptado ni rechazado, así que le pedimos que acepte el permiso.
                    ActivityCompat.requestPermissions(requireActivity(),
                        arrayOf(Manifest.permission.CALL_PHONE),
                        0)

                    startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:637093883")))
                }

                updateButton()
            }
        }.start()

        isTimerRunning = true
        updateButton()
    }

    private fun pauseTimer() {
        countDownTimer.cancel()
        isTimerRunning = false
        updateButton()
    }

    private fun updateCountDownText(timerTextView: TextView) {

        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60

        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        timerTextView.text = timeLeftFormatted
    }

    private fun updateButton() {
        if (isTimerRunning) {
            binding.startButton.text = "Pause"
        } else {
            binding.startButton.text = "Start"
        }
    }
}