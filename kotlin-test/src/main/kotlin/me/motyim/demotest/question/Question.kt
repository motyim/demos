package me.motyim.demotest.question

class Question (id: Int, author: User, var title: String, question: String)
    : QuestionOrAnswer(id, author, question) {

    init {
        if(!isValid())
            throw QuestionException("Question either has no title or body")
    }

    private fun isValid(): Boolean {
        // title and question is valid
        // should not be empty
        // can refactor to have a Title and Body type that can
        // then have it's own validation
        return !(title.isNullOrBlank() || body.isNullOrBlank())
    }

    var answered = false
        private set

    var closed = false
        private set

    var closedReason = ""
        private set

    private val _answers = mutableListOf<Answer>()
    val answers: List<Answer>
        get() {
            return _answers.toList()
        }
    private val _tags = mutableListOf<Tag>()
    val tags: List<Tag>
        get() {
            return _tags.toList()
        }


    // viewed
    // active when?
    // share (this is the permalink)

    override fun vote(direction: VoteEnum) {
        if (closed) {
            throw QuestionException("Question has been de-activated")
        }
        when (direction) {
            VoteEnum.Up -> votes++
            VoteEnum.Down -> votes--
        }
        author.questionOrAnswerVotedOn(direction)
    }

    fun close(reason: String) {
        if (closed) throw QuestionException("Question already closed")
        closed = true
        closedReason = reason
    }

    fun addAnswer(answer: Answer) {
        val answerFromCollection = answers.firstOrNull { it.id == answer.id }

        if(answerFromCollection != null) throw QuestionException("This answer already exists for this question")
        _answers.add(answer)
        answered = true
    }

    fun approveAnswer(answerId: Int) {

        if(answers.any {it.approved})
            throw QuestionException("There is already an approved answer for this question")

        val answer = answers.firstOrNull { it.id == answerId } ?: throw QuestionException("Unable to find answer ro approve")

        answer.approved = true
    }
}