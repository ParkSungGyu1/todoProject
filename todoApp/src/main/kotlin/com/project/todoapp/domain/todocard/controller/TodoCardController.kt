package com.project.todoapp.domain.todocard.controller

import com.project.todoapp.domain.todocard.dtos.CreateTodoCardArguments
import com.project.todoapp.domain.todocard.dtos.TodoCardDto
import com.project.todoapp.domain.todocard.dtos.UpdateTodoCardArguments
import com.project.todoapp.domain.todocard.service.TodoCardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    //선택한 할일 조회 기능
    @GetMapping("/{todoCardId}")
    fun findTodoCard(@PathVariable todoCardId: Long) : ResponseEntity<TodoCardDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCardService.findById(todoCardId))
    }


    @GetMapping
    fun findAllTodoCard() : ResponseEntity<List<TodoCardDto>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCardService.findAll())
    }

    @PutMapping("/{todoCardId}")
    fun updateTodoCard(
        @PathVariable todoCardId: Long,
        @RequestBody updateTodoCardArguments: UpdateTodoCardArguments
    ) : ResponseEntity<TodoCardDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCardService.updateTodoCard(todoCardId,updateTodoCardArguments))
    }

    @DeleteMapping("/{todoCardId}")
    fun deleteTodoCard(@PathVariable todoCardId: Long) : ResponseEntity<Unit>{
        todoCardService.deleteTodoCard(todoCardId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(null)
    }

}