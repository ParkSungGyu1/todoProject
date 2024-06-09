package com.project.todoapp.domain.todo.todocard.dtos

import jakarta.validation.constraints.Size

data class CreateTodoCardArguments (
    //할 일 제목, 할일 내용, 작성일, 작성자 이름
    @field:Size(min = 1, max = 10, message = "크기는 1부터 200까지입니다!!!!")
    val title : String,

    @field:Size(min = 1, max = 10, message = "크기는 1부터 1000까지입니다!!!!")
    val content : String,
    val authorName : String,
    val token : String
)