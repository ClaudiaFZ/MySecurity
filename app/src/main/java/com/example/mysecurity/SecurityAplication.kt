package com.example.mysecurity

import android.app.Application

class SecurityAplication: Application() {
    init {
        usuario.addContactoEmergencia(ContactoEmergencia("Marta", "marta@gmail.com", "777777777", true))
        usuario.addContactoEmergencia(ContactoEmergencia("Ruben", "ruben@gmail.com", "888888888", false))
        usuario.addContactoEmergencia(ContactoEmergencia("Nayra", "nayra@gmail.com", "999999999", false))
    }
    companion object{
        var usuario = Usuario("claudia@gmail.com", "claudia", "666666666")
    }

}

