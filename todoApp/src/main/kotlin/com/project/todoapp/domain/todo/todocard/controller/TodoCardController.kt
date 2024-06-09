package com.project.todoapp.domain.todo.todocard.controller

import com.project.todoapp.domain.todo.todocard.dtos.*
import com.project.todoapp.domain.todo.todocard.service.TodoCardService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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
    fun createTodoCard(@RequestBody @Valid createTodoCardArguments: CreateTodoCardArguments) : ResponseEntity<TodoCardDto>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoCardService.createTodoCard(createTodoCardArguments))

    }

    //선택한 할일 조회 기능
    @GetMapping("/{todoCardId}")
    fun findTodoCard(@PathVariable todoCardId: Long) : ResponseEntity<RetrieveTodoCardDto>{
        val todoCard = todoCardService.findById(todoCardId)
            ?: return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCard)
    }


    @GetMapping
    fun findAllTodoCard(
        @RequestParam sort : String?,
        @RequestParam authorName : String?
    ) : ResponseEntity<List<TodoCardDto>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCardService.findAll(sort, authorName))
    }
    @GetMapping("/with-reply")
    fun findAllTodoCardWithReply(pageable: Pageable) : ResponseEntity<Page<ReplyWithTodoCardDto>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoCardService.findAllWithReply(pageable))
    }

    @PatchMapping("/{todoCardId}/complete")
    fun completeTodoCard(@PathVariable todoCardId: Long) :ResponseEntity<Unit>{

        todoCardService.completeTodoCard(todoCardId)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
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