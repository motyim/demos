package me.motyim.demotest.question

interface IQuestionRepository {
    fun add(question: Question)
    fun update(question: Question)
    fun findQuestion(questionId: Int): Question
}

interface IUserRepository {
    fun findUser(voterId: Int): User
    fun update(user: User)

}


class QuestionRepository : IQuestionRepository {
    override fun findQuestion(questionId: Int): Question {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(question: Question) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(question: Question) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class UserRepository : IUserRepository {
    override fun findUser(voterId: Int): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}