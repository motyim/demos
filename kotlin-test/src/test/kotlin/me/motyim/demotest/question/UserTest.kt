package me.motyim.demotest.question

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTest{

    // make a new object for new test case
    val user = User(1,"motyim")

    @Test
    fun shouldBeAbleToIncreaseReputation(){
        user.changeReputation(10)
        assertEquals(10,user.reputation)
    }


    @Test
    fun shouldBeAbleToDecreaseReputation(){
        user.changeReputation(10)
        user.changeReputation(-5)
        assertEquals(5,user.reputation)
    }
}