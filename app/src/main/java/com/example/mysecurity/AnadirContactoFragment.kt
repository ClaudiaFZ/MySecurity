package com.example.mysecurity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mysecurity.databinding.FragmentAnadirContactoBinding

class AnadirContactoFragment : Fragment() {
    lateinit var binding: FragmentAnadirContactoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_anadir_contacto,
            container,
            false
        )
        return binding.root
    }

}