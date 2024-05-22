package com.project.todoapp.domain.todocard.model

import com.project.todoapp.domain.todocard.dtos.CreateTodoCardArguments
import com.project.todoapp.domain.todocard.dtos.UpdateTodoCardArguments
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
class TodoCards (
    @Column
    var title : String,

    @Column
    var content : String,

    @Column
    var authorName : String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt : LocalDateTime = LocalDateTime.now()

    fun updateTodoCardField(arguments: UpdateTodoCardArguments){
        title = arguments.title
        content = arguments.content
        authorName = arguments.authorName
    }
}