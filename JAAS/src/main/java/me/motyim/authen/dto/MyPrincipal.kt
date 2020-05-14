package me.motyim.authen.dto

import java.io.Serializable
import java.security.Principal

class MyPrincipal(val username: String) : Principal, Serializable {

    override fun getName(): String {
        return username
    }

}