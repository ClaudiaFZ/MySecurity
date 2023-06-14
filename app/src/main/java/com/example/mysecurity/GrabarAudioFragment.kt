package com.example.mysecurity



import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mysecurity.databinding.FragmentGrabarAudioBinding
import java.io.File
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID


class GrabarAudioFragment : Fragment() {
    lateinit var binding: FragmentGrabarAudioBinding
    lateinit var recorder: MediaRecorder
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var path:File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RECORDINGS)
        var nombre = "MySecurity.m4a"
        var file:File = File(path, nombre)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grabar_audio,
            container,
            false
        )

        /*if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            ActivityCompat.requestPermissions(requireActivity(), permissions,0)
        }
        else {*/

        recorder =  MediaRecorder(requireContext())
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        recorder.setOutputFile(file)


        //}

        /*if (ActivityCompat.checkSelfPermission(activity(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity(), new String[]{Manifest.permission.RECORD_AUDIO}, BuildDev.RECORD_AUDIO);

        } */




        try {
            recorder.prepare()
            recorder.start()
            Toast.makeText(requireContext(), "Recording...", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Recording Error , Please restart your app ", Toast.LENGTH_LONG).show()
        }

        /*recorder =  MediaRecorder(requireContext()).apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)

            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)

            try {
                prepare()
                start()
                Toast.makeText(requireContext(), "Recording...", Toast.LENGTH_LONG).show();
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(requireContext(), "Recording Error , Please restart your app ", Toast.LENGTH_LONG).show()
            }
        }*/



        binding.buttonPararGrabacionAudio.setOnClickListener{
            try {
                if (recorder != null) {
                    recorder.stop()
                    recorder.reset()
                    recorder.release()

                } else {
                    Toast.makeText(requireContext(), "Null", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Stop Recording Error :" + e.message, Toast.LENGTH_LONG).show()
            }
            view?.findNavController()?.navigate(R.id.action_grabarAudioFragment_to_principalFragment)
        }
        return binding.root
    }

}
