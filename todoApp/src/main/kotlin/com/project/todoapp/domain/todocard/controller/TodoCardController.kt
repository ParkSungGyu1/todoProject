package com.project.todoapp.domain.todocard.controller

import com.project.todoapp.domain.todocard.dtos.CreateTodoCardArguments
import com.project.todoapp.domain.todocard.dtos.TodoCardDto
import com.project.todoapp.domain.todocard.service.TodoCardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/todo-cards")
@RestController
class TodoCardController (
    private val todoCardService: TodoCardService
) {
    //TODOCARDS 생성
    @PostMapping
    fun createTodoCard(@RequestBody createTodoCardArguments: CreateTodoCardArguments) : ResponseEntity<TodoCardDto>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoCardService.createTodoCard(createTodoCardArguments))

    }
}