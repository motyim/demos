package me.motyim.demotest.question

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be false`
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class UserTest{

    // make a new object for new test case
    val user = User(1,"motyim")

    @Test
    fun `should be able to increase reputation`(){
        user.changeReputation(10)
//        assertEquals(10,user.reputation)
        user.reputation `should be equal to` 10
    }


    @Test
    fun `should be able to decrease reputation`(){
        user.changeReputation(10)
        user.changeReputation(-5)
//        assertEquals(5,user.reputation)
        user.reputation `should be equal to` 5
    }


    @Nested
    inner class `post should be able to` {

        private val editReputationLimit = 2000

        @Test
        fun `edit if reputation is greater than 2000`() {
            user.changeReputation(editReputationLimit+1)
//            assertTrue(user.canEditPost())
            user.canEditPost().shouldBeTrue()
        }

        @Test
        fun `edit if reputation is equal to 2000`() {
            user.changeReputation(editReputationLimit)
            user.canEditPost().`should be false`()
        }

        @Test
        fun `edit if reputation is less than 2000`() {
            user.changeReputation(editReputationLimit-1)
            user.canEditPost().shouldBeFalse()
        }
    }

    @Nested
    inner class comment {

        private val commentReputationLimit = 50

        @Test
        fun `should be able to add if reputation is greater than 50`() {
            user.changeReputation(commentReputationLimit+1)
            user.canComment().shouldBeTrue()
        }

        @Test
        fun `should not be able to add if reputation is equal to 50`() {
            user.changeReputation(commentReputationLimit)
            user.canComment().shouldBeFalse()
        }

        @Test
        fun `should not be able to add if reputation is less than 50`() {
            user.changeReputation(commentReputationLimit-1)
            user.canComment().shouldBeFalse()
        }
    }
}