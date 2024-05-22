package com.project.todoapp.domain.todo.reply.model

import com.project.todoapp.domain.todo.todocard.model.TodoCards
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Reply (
    @Column
    var content : String,

    @Column
    var authorName : String,

    @Column
    var password  : String,

    @ManyToOne
    val todoCards: TodoCards

){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun checkAuthentication(authorName: String, password: String) {
        if(authorName != this.authorName){
            throw Exception("아이디가 맞지 않습니다.")
        }

        if(password != this.password){
            throw Exception("비밀번호가 맞지 않습니다.")
        }
    }

    fun changeContent(content: String) {
        this.content = content
    }
}