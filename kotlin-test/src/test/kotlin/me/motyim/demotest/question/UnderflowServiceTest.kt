@file:Suppress("ClassName")

package me.motyim.demotest.question

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldNotBeNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

internal class UnderflowServiceTest {


    private val questionId = 20
    private val voterId = 10

    @Nested
    inner class `vote up question` {
        private val mockQuestionRepository = mockk<QuestionRepository>(relaxUnitFun = true)
        private val mockUserRepository = mockk<UserRepository>()
        private val underflowService = UnderflowService(mockQuestionRepository, mockUserRepository)

        @Test
        fun `should be able to init service`() {
            underflowService.shouldNotBeNull()
        }

        @Test
        fun `should be able to vote up question`() {
            val user = User(1, "motyim")
            val question = Question(questionId, user, "title", "question")

            user.changeReputation(3000)

            question.voteUp()
            question.voteUp()

            every { mockQuestionRepository.findQuestion(questionId) } returns question
            every { mockUserRepository.findUser(voterId) } returns user
            every { mockUserRepository.findUser(question.userId) } returns user

            every { mockUserRepository.update(user) } just Runs
//            every { mockQuestionRepository.update(question) } just Runs

            val votes = underflowService.voteUpQuestion(questionId, voterId)

            votes `should be` 3
        }

        @Test
        fun `should throw exception`() {

            every { mockQuestionRepository.findQuestion(questionId) } throws Exception()

            invoking { underflowService.voteUpQuestion(questionId, voterId) } `should throw` ServiceException::class
        }
    }


    //using annotation and init method
    @Nested
    inner class `vote up question annotation` {

        //        @MockK
        @RelaxedMockK
        private lateinit var mockQuestionRepository: IQuestionRepository

        @MockK
        private lateinit var mockUserRepository: IUserRepository


        //must use this method with mock annotation
        init {
            MockKAnnotations.init(this)
        }

        private val underflowService = UnderflowService(mockQuestionRepository, mockUserRepository)

        @Test
        fun `should be able to init service`() {
            underflowService.shouldNotBeNull()
        }

        @Test
        fun `should be able to vote up question`() {
            val user = User(1, "motyim")
            val question = Question(questionId, user, "title", "question")

            user.changeReputation(3000)

            question.voteUp()
            question.voteUp()

            every { mockQuestionRepository.findQuestion(questionId) } returns question
            every { mockUserRepository.findUser(voterId) } returns user
            every { mockUserRepository.findUser(question.userId) } returns user

            every { mockUserRepository.update(user) } just Runs
//            every { mockQuestionRepository.update(question) } just Runs

            val votes = underflowService.voteUpQuestion(questionId, voterId)

            votes `should be` 3
        }

        @Test
        fun `should throw exception`() {

            every { mockQuestionRepository.findQuestion(questionId) } throws Exception()

            invoking { underflowService.voteUpQuestion(questionId, voterId) } `should throw` ServiceException::class
        }
    }


    //using annotation without init method
    // must make service in every call as it not init yet
    @Nested
    @ExtendWith(MockKExtension::class)
    inner class `vote up question annotation without init` {

        //        @MockK
        @RelaxedMockK
        private lateinit var mockQuestionRepository: IQuestionRepository

        @MockK
        private lateinit var mockUserRepository: IUserRepository




        @Test
        fun `should be able to init service`() {
            val underflowService = UnderflowService(mockQuestionRepository, mockUserRepository)
            underflowService.shouldNotBeNull()
        }

        @Test
        fun `should be able to vote up question`() {
            val underflowService = UnderflowService(mockQuestionRepository, mockUserRepository)
            val user = User(1, "motyim")
            val question = Question(questionId, user, "title", "question")

            user.changeReputation(3000)

            question.voteUp()
            question.voteUp()

            every { mockQuestionRepository.findQuestion(questionId) } returns question
            every { mockUserRepository.findUser(voterId) } returns user
            every { mockUserRepository.findUser(question.userId) } returns user

            every { mockUserRepository.update(user) } just Runs
//            every { mockQuestionRepository.update(question) } just Runs

            val votes = underflowService.voteUpQuestion(questionId, voterId)

            votes `should be` 3
        }

        @Test
        fun `should throw exception`() {
            val underflowService = UnderflowService(mockQuestionRepository, mockUserRepository)
            every { mockQuestionRepository.findQuestion(questionId) } throws Exception()

            invoking { underflowService.voteUpQuestion(questionId, voterId) } `should throw` ServiceException::class
        }
    }


}