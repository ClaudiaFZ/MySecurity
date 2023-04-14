package com.example.mysecurity

class Usuario(var correo:String, var pass: String, var telefono: String) {
    var contactosEmergencia:MutableList<ContactoEmergencia> = mutableListOf()
    //lateinit var ubicacion:Ubicacion

    fun addContactoEmergencia(contacto:ContactoEmergencia){
        contactosEmergencia.add(contacto)
    }
}