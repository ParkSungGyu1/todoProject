package com.project.todoapp.domain.todo.reply.dto

data class CreateReplyArgument (
    val content : String,
    val authorName : String,
    val password : String,
)
