package com.example.mysecurity

class Usuario(var correo:String, var pass: String, var telefono: String) {
    lateinit var contactosEmergencia:MutableList<ContactoEmergencia>
    lateinit var ubicacion:Ubicacion

    fun addContactoEmergencia(contacto:ContactoEmergencia){
        contactosEmergencia.add(contacto)
    }
}