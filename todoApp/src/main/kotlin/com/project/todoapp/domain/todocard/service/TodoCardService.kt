package com.project.todoapp.domain.todocard.service

import com.project.todoapp.domain.todocard.dtos.CreateTodoCardArguments
import com.project.todoapp.domain.todocard.dtos.TodoCardDto
import com.project.todoapp.domain.todocard.model.TodoCards
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TodoCardService {

    // DB로 데이터를 저장
    @Transactional
    fun createTodoCard(createTodoCardArguments: CreateTodoCardArguments): TodoCardDto {
        //DTO를 Entity 변환
        val todo = TodoCards.from(createTodoCardArguments)



    }
}