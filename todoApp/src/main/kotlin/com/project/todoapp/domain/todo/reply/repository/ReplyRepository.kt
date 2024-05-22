package com.project.todoapp.domain.todo.reply.repository

import com.project.todoapp.domain.todo.reply.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long>