package com.project.todoapp.domain.todocard.dtos

import com.project.todoapp.domain.todocard.model.TodoCards

data class TodoCardDto (
    val title : String,
    val content : String,
    val authorName : String
) {
    companion object{
        fun from (todoCards: TodoCards) : TodoCardDto{
            return TodoCardDto(
                todoCards.title,
                todoCards.content,
                todoCards.authorName
            )
        }
    }
}
