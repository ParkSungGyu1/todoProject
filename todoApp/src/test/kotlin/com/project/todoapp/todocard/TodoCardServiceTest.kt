package com.project.todoapp.todocard

import com.project.todoapp.domain.todo.todocard.model.TodoCards
import com.project.todoapp.domain.todo.todocard.repository.TodoCardRepository
import com.project.todoapp.domain.todo.todocard.service.TodoCardService
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.mockk
import org.springframework.data.repository.findByIdOrNull

class TodoCardServiceTest : BehaviorSpec({
    val todoCardRepository = mockk<TodoCardRepository>()
    val savedTodoCard = TodoCards(
        title = "title",
        content = "content",
        authorName = "authorName"
    )
    savedTodoCard.id = 1L

    every { todoCardRepository.findByIdOrNull(1L) } returns savedTodoCard
    every { todoCardRepository.findByIdOrNull(10L) } returns null

    val todoCardService = TodoCardService(todoCardRepository)


    Given("saved todo card id"){
        val targetTodoCarId = 1L
        When("todoCardRepository findById"){
            val result = todoCardService.findById(targetTodoCarId)

            Then("result should not be null"){
                result shouldNotBe null
                result?.let {
                    it.id shouldBe savedTodoCard.id
                    it.title shouldBe savedTodoCard.title
                    it.content shouldBe savedTodoCard.content
                    it.authorName shouldBe savedTodoCard.authorName
                }
            }
        }
    }

    Given("not saved todo card id"){
        val nonTargetTodoCardId = 10L
        When("todoCardRepository findById") {
            val result = todoCardService.findById(nonTargetTodoCardId)
            Then("result should be null"){
                result shouldBe null
            }
        }
    }
})