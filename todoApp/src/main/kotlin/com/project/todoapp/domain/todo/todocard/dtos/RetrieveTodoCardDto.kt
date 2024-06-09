package com.project.todoapp.domain.todo.todocard.dtos

import com.project.todoapp.domain.todo.reply.dto.ReplyDto
import com.project.todoapp.domain.todo.todocard.model.TodoCards

data class RetrieveTodoCardDto (
    val id : Long?,
    val title : String,
    val content : String,
    val authorName : String,
    val reply: List<ReplyDto>
) {
    companion object{
        fun from (todoCards: TodoCards) : RetrieveTodoCardDto? {
            return RetrieveTodoCardDto(
                todoCards.id,
                todoCards.title,
                todoCards.content,
                todoCards.authorName,
                todoCards.reply.map { ReplyDto.from(it) }
            )
        }
    }
}
