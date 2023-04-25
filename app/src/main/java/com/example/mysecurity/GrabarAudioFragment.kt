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
import com.example.mysecurity.databinding.FragmentGrabarAudioBinding
import java.io.IOException
import java.util.UUID


class GrabarAudioFragment : Fragment() {
    lateinit var binding: FragmentGrabarAudioBinding
    lateinit var recorder: MediaRecorder
    private var fileName: String = Environment.getExternalStorageDirectory().absolutePath + "/" + UUID.randomUUID().toString() + "audio_record.m4a"

    private fun setUpMediaRecorder() {

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grabar_audio,
            container,
            false
        )

        /*if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            ActivityCompat.requestPermissions(requireActivity(), permissions,0)
        }*/

        /*recorder =  MediaRecorder(requireContext())
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)

        recorder.setOutputFile(fileName)
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)

        try {
            recorder.prepare()
            recorder.start()
            Toast.makeText(requireContext(), "Recording...", Toast.LENGTH_LONG).show();
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Recording Error , Please restart your app ", Toast.LENGTH_LONG).show()
        }*/

        recorder =  MediaRecorder(requireContext()).apply {
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
        }



        binding.buttonPararGrabacionAudio.setOnClickListener{
            try {
                if (recorder != null) {
                    recorder.stop()
                    recorder.reset()
                    recorder.release()

                    //sendVoice();
                    //chatService.sendVoice(audio_path)
                    // Guardar audio
                } else {
                    Toast.makeText(requireContext(), "Null", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Stop Recording Error :" + e.message, Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    /*private fun startRecord() {
        setUpMediaRecorder()
        try {
            mediaRecorder.prepare()
            mediaRecorder.start()
            //  Toast.makeText(InChatActivity.this, "Recording...", Toast.LENGTH_LONG).show();
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(
                this@ChatsActivity,
                "Recording Error , Please restart your app ",
                Toast.LENGTH_LONG
            ).show()
        }
    }*/

    /*private fun stopRecord() {
        try {
            if (mediaRecorder != null) {
                mediaRecorder.stop()
                mediaRecorder.reset()
                mediaRecorder.release()
                mediaRecorder = null

                //sendVoice();
                chatService.sendVoice(audio_path)
            } else {
                Toast.makeText(getApplicationContext(), "Null", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(
                getApplicationContext(),
                "Stop Recording Error :" + e.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }*/
}
/*private const val LOG_TAG = "AudioRecordTest"
private const val REQUEST_RECORD_AUDIO_PERMISSION = 200

class GrabarAudioFragment : Fragment() {

    private var fileName: String = ""

    private var recordButton: RecordButton? = null
    private var recorder: MediaRecorder? = null

    private var playButton: PlayButton? = null
    private var player: MediaPlayer? = null

    // Requesting permission to RECORD_AUDIO
    private var permissionToRecordAccepted = false
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted) finish()
    }

    private fun onRecord(start: Boolean) = if (start) {
        startRecording()
    } else {
        stopRecording()
    }

    private fun onPlay(start: Boolean) = if (start) {
        startPlaying()
    } else {
        stopPlaying()
    }

    private fun startPlaying() {
        player = MediaPlayer().apply {
            try {
                setDataSource(fileName)
                prepare()
                start()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }
        }
    }

    private fun stopPlaying() {
        player?.release()
        player = null
    }

    private fun startRecording() {
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }

            start()
        }
    }

    private fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
    }

    internal inner class RecordButton(ctx: Context) : androidx.appcompat.widget.AppCompatButton(ctx) {

        var mStartRecording = true

        var clicker: OnClickListener = OnClickListener {
            onRecord(mStartRecording)
            text = when (mStartRecording) {
                true -> "Stop recording"
                false -> "Start recording"
            }
            mStartRecording = !mStartRecording
        }

        init {
            text = "Start recording"
            setOnClickListener(clicker)
        }
    }

    internal inner class PlayButton(ctx: Context) : androidx.appcompat.widget.AppCompatButton(ctx) {
        var mStartPlaying = true
        var clicker: OnClickListener = OnClickListener {
            onPlay(mStartPlaying)
            text = when (mStartPlaying) {
                true -> "Stop playing"
                false -> "Start playing"
            }
            mStartPlaying = !mStartPlaying
        }

        init {
            text = "Start playing"
            setOnClickListener(clicker)
        }
    }

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        // Record to the external cache directory for visibility
        fileName = "${requireContext().externalCacheDir?.absolutePath}/audiorecordtest.3gp"

        ActivityCompat.requestPermissions(requireActivity(), permissions, REQUEST_RECORD_AUDIO_PERMISSION)

        recordButton = RecordButton(requireContext())
        playButton = PlayButton(requireContext())
        val ll = LinearLayout(requireContext()).apply {
            addView(recordButton,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    0f))
            addView(playButton,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    0f))
        }
        //setContentView(ll)
    }

    override fun onStop() {
        super.onStop()
        recorder?.release()
        recorder = null
        player?.release()
        player = null
    }
}
*/