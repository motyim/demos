package me.motyim.demotest.question

import org.amshove.kluent.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

@Suppress("ClassName")
class QuestionTest {

    val user = User(1, "motyim")

    @Nested
    inner class `constructor should` {

        @Test
        fun `throw exception if title is empty`() {

            invoking { Question(1, user, "", "Question") } `should throw` QuestionException::class

//            assertThrows(QuestionException::class.java){
//                Question(1,user,"","Question")
//            }
        }

        @Test
        fun `throw exception if body is empty`() {

            invoking { Question(1, user, "title", "") } `should throw` QuestionException::class

//            assertThrows(QuestionException::class.java) {
//                Question(1, user, "title", "")
//            }
        }

        @Test
        fun `not throw exception if question is valid`() {

            invoking { Question(1, user, "title", "Question") } `should not throw` QuestionException::class
//            assertDoesNotThrow {
//                Question(1, user, "title", "Question")
//            }
        }

        @ParameterizedTest
        @CsvSource(
            "'',question"
            , "' ',question"
            , "title,''"
            , "title,' '"
            , "'',''"
        )
        fun `throw an exception if title or questions not valid`(title: String, body: String) {
            invoking { Question(1, user, title, body) } `should throw` QuestionException::class
//            assertThrows(QuestionException::class.java) {
//                Question(1, user, title, body)
//            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class `constructor should with method source` {
        @CsvSource(
            "'',question"
            , "' ',question"
            , "title,''"
            , "title,' '"
            , "'',''"
        )

        @Suppress("unused")
        fun titleAndQuestions() = listOf(
            Arguments.of("", "Questions"),
            Arguments.of(" ", "Questions"),
            Arguments.of("title", ""),
            Arguments.of("title", " "),
            Arguments.of("", "")
        )

        @ParameterizedTest
        @MethodSource("titleAndQuestions")
        fun `throw an exception if title or questions not valid`(title: String, body: String) {
            assertThrows(QuestionException::class.java) {
                Question(1, user, title, body)
            }
        }

    }

    @Nested
    @KotlinParameterizedTests
    inner class `constructor should with method source with annotation` {
        @CsvSource(
            "'',question"
            , "' ',question"
            , "title,''"
            , "title,' '"
            , "'',''"
        )

        @Suppress("unused")
        fun titleAndQuestions() = listOf(
            Arguments.of("", "Questions"),
            Arguments.of(" ", "Questions"),
            Arguments.of("title", ""),
            Arguments.of("title", " "),
            Arguments.of("", "")
        )

        @ParameterizedTest
        @MethodSource("titleAndQuestions")
        fun `throw an exception if title or questions not valid`(title: String, body: String) {
            assertThrows(QuestionException::class.java) {
                Question(1, user, title, body)
            }
        }

    }


    @Nested
    inner class answer{

        private val user = User(1,"motyim")
        private val question = Question(1,user,"title","question")

        @Test
        fun `should have no answer`(){
            question.answers.shouldBeEmpty()
        }

        @Test
        fun `should have answer`(){
            val answer = Answer(1,user,"answer")
            question.addAnswer(answer)
            question.answers.shouldNotBeEmpty()
        }

        @Test
        fun `should contain answer`(){
            val answer = Answer(1,user,"answer")
            question.addAnswer(answer)

            question.answers `should contain` answer
        }

        @Test
        fun `should contain answer if two added`(){
            val answer = Answer(1,user,"answer")
            question.addAnswer(answer)

            val answer2 = Answer(2,user,"answer2")
            question.addAnswer(answer2)

            question.answers `should contain` answer
        }

        @Test
        fun `should not contain answer if not added`(){
            val answer = Answer(1,user,"answer")

            val answer2 = Answer(2,user,"answer2")
            question.addAnswer(answer2)

            question.answers `should not contain` answer
        }

        @Test
        fun `should have two answer if two added`(){
            val answer = Answer(1,user,"answer")
            question.addAnswer(answer)
            val answer2 = Answer(2,user,"answer2")
            question.addAnswer(answer2)

            question.answers  `should contain all` arrayListOf(answer,answer2)
        }

    }
}