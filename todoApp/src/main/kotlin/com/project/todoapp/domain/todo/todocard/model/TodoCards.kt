package com.project.todoapp.domain.todo.todocard.model

import com.project.todoapp.domain.todo.reply.model.Reply
import com.project.todoapp.domain.todo.todocard.TodoCardException
import com.project.todoapp.domain.todo.todocard.dtos.CreateTodoCardArguments
import com.project.todoapp.domain.todo.todocard.dtos.UpdateTodoCardArguments
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
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

    init {
        if(this.title.isEmpty() || this.title.length > 10){
            throw TodoCardException("title의 크기는 1부터 10까지입니다!!!!")
        }

        if(this.content.isEmpty() || this.content.length > 10){
            throw TodoCardException("content의 크기는 1부터 10까지입니다!!!!")
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt : LocalDateTime = LocalDateTime.now()

    @Column(name = "is_completed")
    private var _isCompleted : Boolean = false

    @OneToMany(mappedBy = "todoCards", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    val reply : List<Reply> = emptyList()

    fun complete(){
        _isCompleted = true
    }

    fun getIsCompleted() : Boolean{
        return _isCompleted
    }

    fun updateTodoCardField(arguments: UpdateTodoCardArguments){
        title = arguments.title
        content = arguments.content
        authorName = arguments.authorName
    }
}