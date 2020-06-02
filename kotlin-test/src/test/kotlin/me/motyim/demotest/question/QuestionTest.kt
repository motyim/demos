package me.motyim.demotest.question

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

@Suppress("ClassName")
class QuestionTest{

    val user = User(1,"motyim")

    @Nested
    inner class `constructor should`{

        @Test
        fun `throw exception if title is empty`(){
            assertThrows(QuestionException::class.java){
                Question(1,user,"","Question")
            }
        }

        @Test
        fun `throw exception if body is empty`(){
            assertThrows(QuestionException::class.java){
                Question(1,user,"title","")
            }
        }

        @Test
        fun `not throw exception if question is valid`(){
            assertDoesNotThrow{
                Question(1,user,"title","Question")
            }
        }

        @ParameterizedTest
        @CsvSource("'',question"
                ,"' ',question"
                ,"title,''"
                ,"title,' '"
                ,"'',''")
        fun `throw an exception if title or questions not valid`(title:String,body:String){
            assertThrows(QuestionException::class.java){
                Question(1,user,title,body)
            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class `constructor should with method source`{
        @CsvSource("'',question"
                ,"' ',question"
                ,"title,''"
                ,"title,' '"
                ,"'',''")

        @Suppress("unused")
        fun titleAndQuestions() = listOf(
            Arguments.of("","Questions"),
            Arguments.of(" ","Questions"),
            Arguments.of("title",""),
            Arguments.of("title"," "),
            Arguments.of("","")
        )

        @ParameterizedTest
        @MethodSource("titleAndQuestions")
        fun `throw an exception if title or questions not valid`(title:String,body:String){
            assertThrows(QuestionException::class.java){
                Question(1,user,title,body)
            }
        }

    }

    @Nested
    @KotlinParameterizedTests
    inner class `constructor should with method source with annotation`{
        @CsvSource("'',question"
                ,"' ',question"
                ,"title,''"
                ,"title,' '"
                ,"'',''")

        @Suppress("unused")
        fun titleAndQuestions() = listOf(
                Arguments.of("","Questions"),
                Arguments.of(" ","Questions"),
                Arguments.of("title",""),
                Arguments.of("title"," "),
                Arguments.of("","")
        )

        @ParameterizedTest
        @MethodSource("titleAndQuestions")
        fun `throw an exception if title or questions not valid`(title:String,body:String){
            assertThrows(QuestionException::class.java){
                Question(1,user,title,body)
            }
        }

    }

}