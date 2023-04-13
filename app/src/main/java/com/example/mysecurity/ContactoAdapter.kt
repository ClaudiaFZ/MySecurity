package com.example.mysecurity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysecurity.databinding.FragmentCompartirUbicacionBinding
import com.example.mysecurity.databinding.UbicacionItemBinding

class ContactoAdapter: RecyclerView.Adapter<ContactoAdapter.ContactoHolder>() {
    var data = listOf<ContactoEmergencia>()
    lateinit var binding: UbicacionItemBinding

    inner class ContactoHolder(view: View) : RecyclerView.ViewHolder(view){
        private var local = binding

        fun bind(contacto: ContactoEmergencia){
           local.contacto = contacto
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = UbicacionItemBinding.inflate(layoutInflater, parent, false)
        return ContactoHolder(binding.root)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {
        // Llama al método bind y pásale la tarjeta con índice position
        holder.bind(data[position])
    }
}