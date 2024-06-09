package com.project.todoapp.todocard

import com.project.todoapp.domain.todo.todocard.TodoCardException
import com.project.todoapp.domain.todo.todocard.model.TodoCards
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TodoCardTest : BehaviorSpec({
    Given("TodoCard Information") {
        val title = "title"
        val content = "content"
        val authorName = "authorName"

        When("TodoCard Constructor"){
            val result = TodoCards(
                title = title,
                content = content,
                authorName = authorName
            )

            Then("Result Should be"){
                result.title shouldBe title
                result.content shouldBe content
                result.authorName shouldBe authorName
            }
        }
    }

    Given("todo card with empty title"){
        val title = ""
        val content = "content"
        val authorName = "authorName"

        When("TodoCard Constructor"){
            val result = shouldThrow<TodoCardException> {
                TodoCards(
                    title = title,
                    content = content,
                    authorName = authorName
                )
            }
            Then("throw exception message"){
                result.message shouldBe "title의 크기는 1부터 10까지입니다!!!!"
            }
        }
    }

    Given("todo card with empty content"){
        val title = "title"
        val content = ""
        val authorName = "authorName"

        When("TodoCard Constructor"){
            val result = shouldThrow<TodoCardException> {
                TodoCards(
                    title = title,
                    content = content,
                    authorName = authorName
                )
            }
            Then("throw exception message"){
                result.message shouldBe "content의 크기는 1부터 10까지입니다!!!!"
            }
        }
    }

    Given("todo card with too long title"){
        val title = "100000000000000000000"
        val content = "content"
        val authorName = "authorName"

        When("TodoCard Constructor"){
            val result = shouldThrow<TodoCardException> {
                TodoCards(
                    title = title,
                    content = content,
                    authorName = authorName
                )
            }
            Then("throw exception message"){
                result.message shouldBe "title의 크기는 1부터 10까지입니다!!!!"
            }
        }
    }

    Given("todo card with too long content"){
        val title = "title"
        val content = "100000000000000000000"
        val authorName = "authorName"

        When("TodoCard Constructor"){
            val result = shouldThrow<TodoCardException> {
                TodoCards(
                    title = title,
                    content = content,
                    authorName = authorName
                )
            }
            Then("throw exception message"){
                result.message shouldBe "content의 크기는 1부터 10까지입니다!!!!"
            }
        }
    }
})
