package me.motyim.authen.handler

import java.io.IOException
import javax.security.auth.callback.*

class MyCallBackHandler : CallbackHandler {
    override fun handle(callbacks: Array<out Callback>?) {
        callbacks?.forEach {

            when (it) {
                is TextOutputCallback -> {
                    when (it.messageType) {
                        TextOutputCallback.INFORMATION -> println(it.message)
                        TextOutputCallback.ERROR -> println("Error : ${it.message}")
                        TextOutputCallback.WARNING -> println("Warning : ${it.message}")
                        else -> throw IOException("Unsupported Callback")
                    }
                }
                is NameCallback -> {
                    println(it.prompt)
                    println("Please Enter username :")
                    val username = readLine()
                    it.name = username
                }
                is PasswordCallback -> {
                    println(it.prompt)
                    println("Please Enter Password :")
                    val password = readLine()
                    it.password = password?.toCharArray()
                }
                else -> throw UnsupportedCallbackException(it, "Unsupported Callback")
            }
        }
    }
}