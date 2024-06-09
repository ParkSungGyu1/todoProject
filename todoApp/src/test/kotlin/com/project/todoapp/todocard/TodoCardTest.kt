package com.project.todoapp.todocard

import com.project.todoapp.domain.todo.todocard.model.TodoCards
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
})
