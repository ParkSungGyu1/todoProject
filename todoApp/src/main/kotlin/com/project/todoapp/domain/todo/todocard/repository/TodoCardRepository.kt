package com.project.todoapp.domain.todo.todocard.repository

import com.project.todoapp.domain.todo.todocard.model.TodoCards
import org.springframework.data.jpa.repository.JpaRepository

interface TodoCardRepository : JpaRepository<TodoCards, Long>{
    fun findAllByOrderByCreatedAtDesc() : List<TodoCards>
    fun findAllByOrderByCreatedAtAsc() : List<TodoCards>
    fun findAllByAuthorName(authorName : String) : List<TodoCards>
}