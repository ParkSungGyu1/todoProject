package com.project.todoapp.domain.todo.todocard.repository

import com.project.todoapp.domain.todo.todocard.model.TodoCards
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TodoCardRepository : JpaRepository<TodoCards, Long>{
    fun findAllByOrderByCreatedAtDesc() : List<TodoCards>
    fun findAllByOrderByCreatedAtAsc() : List<TodoCards>
    fun findAllByAuthorName(authorName : String) : List<TodoCards>


    @Query("select distinct t from TodoCards t left join fetch t.reply")
    fun findAllFetchJPQL(pageable: Pageable) : Page<TodoCards>
}