package com.project.todoapp.domain.todo.todocard.repository

import com.project.todoapp.domain.QueryDSLSupport
import com.project.todoapp.domain.todo.reply.model.QReply
import com.project.todoapp.domain.todo.todocard.model.QTodoCards
import com.project.todoapp.domain.todo.todocard.model.TodoCards
import org.springframework.stereotype.Component

@Component
class TodoCardQueryDSLRepostiory : QueryDSLSupport() {

    private val todoCard = QTodoCards.todoCards
    private val reply = QReply.reply


    fun findAllByOrderByCreatedAtDesc() : List<TodoCards>{
        return queryFactory.selectFrom(todoCard)
            .leftJoin(todoCard.reply, reply)
            .fetchJoin()
            .orderBy(todoCard.createdAt.desc())
            .fetch()

    }

    fun findAllByOrderByCreatedAtAsc() : List<TodoCards>{
        return queryFactory.selectFrom(todoCard)
            .leftJoin(todoCard.reply, reply)
            .fetchJoin()
            .orderBy(todoCard.createdAt.asc())
            .fetch()

    }

    fun findAllByAuthorName(authorName : String) : List<TodoCards>{
        return queryFactory.selectFrom(todoCard)
            .leftJoin(todoCard.reply, reply)
            .fetchJoin()
            .where(todoCard.authorName.eq(authorName))
            .fetch()
    }
}