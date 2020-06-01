package me.motyim.demotest.question

abstract class QuestionOrAnswer(var id:Int,var author:User,val body:String) {
    var votes = 0
        protected set
    var userId = 0
        protected set

    private val _comments = listOf<Comment>()

    val comments: List<Comment>
        get() = _comments.toList()

    abstract fun vote(direction: VoteEnum)

    fun voteUp(): Int {
        vote(VoteEnum.Up)
        return votes
    }

    fun voteDown(): Int {
        vote(VoteEnum.Down)
        return votes
    }
}