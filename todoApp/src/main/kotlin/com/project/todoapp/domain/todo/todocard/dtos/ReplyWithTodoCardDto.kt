package com.project.todoapp.domain.todo.todocard.dtos

import com.project.todoapp.domain.todo.reply.dto.ReplyDto
import com.project.todoapp.domain.todo.todocard.model.TodoCards

data class ReplyWithTodoCardDto (
    val title : String,
    val content : String,
    val authorName : String,
    val reply: List<ReplyDto>
) {
    companion object{
        fun from (todoCards: TodoCards) : ReplyWithTodoCardDto {
            return ReplyWithTodoCardDto(
                todoCards.title,
                todoCards.content,
                todoCards.authorName,
                todoCards.reply.map { ReplyDto.from(it) }
            )
        }
    }
}
