package me.motyim.demotest.question

import me.motyim.demotest.question.VoteEnum

class User(val id :Int, val name:String) {
    var reputation = 0
        private set

    fun questionOrAnswerVotedOn(direction: VoteEnum) {
        when (direction) {
            VoteEnum.Up -> reputation++
            VoteEnum.Down -> reputation--
        }
    }

    fun changeReputation(amount: Int) {
        reputation += amount
    }

    fun canEditPost():Boolean {
        return reputation > 2000
    }

    fun canComment():Boolean {
        return reputation > 50
    }

    fun canVote():Boolean {
        return reputation > 15
    }
}