package me.motyim.authen

import me.motyim.authen.handler.MyCallBackHandler
import javax.security.auth.login.LoginContext
import javax.security.auth.login.LoginException

fun main() {
    val loginContext = LoginContext("Auth",MyCallBackHandler())
    var loged = false

    for (i in 1..3){
        try {
            loginContext.login()
            loged = true
            break
        }catch (e: LoginException){
            println("Authen Failed...${e.message}")
        }
    }

    println("User Loged : $loged")
}