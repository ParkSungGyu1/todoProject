package com.project.todoapp.domain.todocard.repository

import com.project.todoapp.domain.todocard.model.TodoCards
import org.springframework.data.jpa.repository.JpaRepository

interface TodoCardRepository : JpaRepository<TodoCards, Long>{
    fun findAllByOrderByCreatedAtDesc() : List<TodoCards>
}