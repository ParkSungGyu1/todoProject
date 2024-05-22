package com.project.todoapp.domain.todo.reply.controller

import com.project.todoapp.domain.todo.reply.dto.CreateReplyArgument
import com.project.todoapp.domain.todo.reply.dto.DeleteReplyArgument
import com.project.todoapp.domain.todo.reply.dto.ReplyDto
import com.project.todoapp.domain.todo.reply.dto.UpdateReplyArgument
import com.project.todoapp.domain.todo.reply.service.ReplyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/todo-cards/{todoCardId}/replies")
@RestController
class ReplyController(
    private val replyService : ReplyService
) {

    @PostMapping
    fun createReply(@RequestBody createReplyArgument : CreateReplyArgument, @PathVariable todoCardId: Long) : ResponseEntity<ReplyDto>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(replyService.createReply(todoCardId, createReplyArgument))
    }

    @PutMapping("/{replyId}")
    fun updateReply(
        @PathVariable replyId: Long,
        @PathVariable todoCardId: Long,
        @RequestBody updateReplyArgument : UpdateReplyArgument
    ) : ResponseEntity<ReplyDto>{

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(replyService.updateReply(replyId, todoCardId, updateReplyArgument))
    }

    @DeleteMapping("/{replyId}")
    fun deleteReply(
        @PathVariable replyId: Long,
        @PathVariable todoCardId: Long,
        @RequestBody deleteReplyArgument: DeleteReplyArgument
    ) : ResponseEntity<Unit>{
        replyService.deleteReply(replyId,todoCardId,deleteReplyArgument)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
    }

}