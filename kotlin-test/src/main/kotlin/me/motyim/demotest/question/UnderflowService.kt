package me.motyim.demotest.question

interface IUnderflowService {
    fun addQuestion(userId: Int, questionId: Int)
    fun addAnswer(userId: Int, answerId: Int)
    fun voteUpQuestion(questionId: Int, voterId: Int): Int
    fun voteDownQuestion(questionId: Int, voterId: Int): Int
}

interface IUserService {
    fun createUser(): User
    fun addBadge(userId: Int, badgeId: Int): Unit
}

class UnderflowService(val questionRepository: IQuestionRepository, val userRepository: IUserRepository) : IUnderflowService {

    override fun addAnswer(userId: Int, answerId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addQuestion(userId: Int, questionId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun voteUpQuestion(questionId: Int, voterId: Int): Int {
        try {
            val question: Question = questionRepository.findQuestion(questionId)
            val voter: User = userRepository.findUser(voterId)
            val owner: User = userRepository.findUser(question.userId)

            if (voter.canVote()) {
                question.voteUp()
                owner.questionOrAnswerVotedOn(VoteEnum.Up)
            } else throw QuestionException("User does not have enough reputation to vote")
            questionRepository.update(question)
            userRepository.update(owner)
            return question.votes
        } catch (e: Exception) {
            throw ServiceException("Unable to vote up question")
        }
    }

    override fun voteDownQuestion(questionId: Int, voterId: Int): Int {
        val question: Question = questionRepository.findQuestion(questionId)
        val voter: User = userRepository.findUser(voterId)
        val owner: User = userRepository.findUser(question.userId)

        if (voter.canVote()) {
            question.voteDown()
            owner.questionOrAnswerVotedOn(VoteEnum.Down)
        } else throw QuestionException("User does not have enough reputation to vote")
        questionRepository.update(question)
        userRepository.update(owner)
        return question.votes
    }
}

class UserService(val userRepository: IUserRepository) : IUserService {
    override fun addBadge(userId: Int, badgeId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}



