package com.project.todoapp.domain.todo.reply.dto

import com.project.todoapp.domain.todo.reply.model.Reply

data class ReplyDto (
    val content : String,
    val authorName : String
){
    companion object{
        fun from(reply: Reply) : ReplyDto{
            return ReplyDto(
                reply.content,
                reply.authorName
            )
        }
    }
}
