package me.motyim.authen.module

import me.motyim.authen.dto.MyPrincipal
import javax.security.auth.Subject
import javax.security.auth.callback.Callback
import javax.security.auth.callback.CallbackHandler
import javax.security.auth.callback.NameCallback
import javax.security.auth.callback.PasswordCallback
import javax.security.auth.login.FailedLoginException
import javax.security.auth.login.LoginException
import javax.security.auth.spi.LoginModule

class SampleLoginModule : LoginModule {

    private var debug: Boolean = false
    private var subject: Subject? = null
    private var callbackHandler: CallbackHandler? = null

    private lateinit var principal: MyPrincipal
    private lateinit var name: String
    private lateinit var password: CharArray


    override fun initialize(subject: Subject?, callbackHandler: CallbackHandler?, sharedState: MutableMap<String, *>?, options: MutableMap<String, *>?) {
        this.subject = subject
        this.callbackHandler = callbackHandler
        debug = "true" == options?.get("debug") as String
    }

    override fun login(): Boolean {
        if (callbackHandler == null)
            throw LoginException("No Callback Handler found")

        val callbacks: Array<Callback>? = arrayOf(
                NameCallback("username :"),
                PasswordCallback("password", false)
        )

        callbackHandler?.handle(callbacks)
        name = (callbacks?.get(0) as NameCallback).name
        val tempPassword = (callbacks?.get(1) as PasswordCallback).password ?: charArrayOf()
        password = tempPassword.copyOf()
        (callbacks?.get(1) as PasswordCallback).clearPassword()

        if (debug) {
            println("You Enter Username : $name")
            println("You Enter Password : ${String(password)}")
        }

        if (name == "motyim" && String(password) == "123") {
            print("Auth Successfully ")
        } else {
            throw FailedLoginException("Username or Password Incorrect")
        }

        return true
    }

    // if login success
    override fun commit(): Boolean {
        principal = MyPrincipal(name);
        if (subject?.principals?.contains(principal) != true) {
            subject?.principals?.add(principal)
        }
        if (debug) {
            println("MyPrincipal Added")
        }
        return true
    }

    override fun logout(): Boolean {
        subject?.principals?.remove(principal)
        clearData()
        return true
    }


    // if exception during login
    override fun abort(): Boolean {
        logout()
        return true
    }

    private fun clearData() {
        name = ""
        password = charArrayOf()
    }

}