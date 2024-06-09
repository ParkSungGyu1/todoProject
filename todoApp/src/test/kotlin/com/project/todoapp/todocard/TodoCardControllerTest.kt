package com.project.todoapp.todocard

import com.project.todoapp.domain.common.exception.ModelNotFoundException
import com.project.todoapp.domain.todo.reply.dto.ReplyDto
import com.project.todoapp.domain.todo.todocard.controller.TodoCardController
import com.project.todoapp.domain.todo.todocard.dtos.RetrieveTodoCardDto
import com.project.todoapp.domain.todo.todocard.service.TodoCardService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.MockKStubScope
import io.mockk.every
import io.mockk.mockk
import org.springframework.http.HttpStatus

class TodoCardControllerTest : BehaviorSpec({
    val savedTodoCardId = 1L
    val notSavedTodoCardId = 10L
    val todoCardService = mockk<TodoCardService>()

    val todoCardController = TodoCardController(todoCardService)

    every { todoCardService.findById(savedTodoCardId) } returns RetrieveTodoCardDto(
        id = savedTodoCardId,
        title = "title",
        content = "content",
        authorName = "authorName",
        reply = emptyList()
    )

    every { todoCardService.findById(notSavedTodoCardId) } returns null

    Given("saved todo card id"){
        val targetTodoCardId = savedTodoCardId
        When("findTodoCardId") {
            val result = todoCardController.findTodoCard(targetTodoCardId)

            Then("status code should be ok"){
                result.statusCode shouldBe HttpStatus.OK
                result.body?.id shouldBe savedTodoCardId
            }
        }
    }

    Given("not saved todo card id"){
        val targetTodoCardId = notSavedTodoCardId
        When("findTodoCardId") {
            val result = todoCardController.findTodoCard(targetTodoCardId)

            Then("status code should be not found"){
                result.statusCode shouldBe HttpStatus.NOT_FOUND
                result.body shouldBe null
            }
        }
    }
})
