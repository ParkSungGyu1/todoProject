package com.project.todoapp.domain.todo.reply.service

import com.project.todoapp.domain.common.exception.ModelNotFoundException
import com.project.todoapp.domain.todo.reply.dto.CreateReplyArgument
import com.project.todoapp.domain.todo.reply.dto.DeleteReplyArgument
import com.project.todoapp.domain.todo.reply.dto.ReplyDto
import com.project.todoapp.domain.todo.reply.dto.UpdateReplyArgument
import com.project.todoapp.domain.todo.reply.model.Reply
import com.project.todoapp.domain.todo.reply.repository.ReplyRepository
import com.project.todoapp.domain.todo.todocard.repository.TodoCardRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReplyService (
    private val replyRepository: ReplyRepository,
    private val todoRepository: TodoCardRepository
) {

    @Transactional
    fun createReply(todoCardId: Long, argument: CreateReplyArgument): ReplyDto {
        val foundTodoCard = todoRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard", todoCardId)

        val reply = Reply(
            argument.content,
            argument.authorName,
            argument.password,
            foundTodoCard
        )

        val savedReply = replyRepository.save(reply)

        return ReplyDto.from(savedReply)
    }

    @Transactional
    fun updateReply(replyId: Long, todoCardId: Long, argument: UpdateReplyArgument): ReplyDto {
        val foundTodoCard = todoRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard", todoCardId)
        val foundReply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        foundReply.checkAuthentication(argument.authorName, argument.password)
        foundReply.changeContent(argument.content)

        return ReplyDto.from(foundReply)
    }

    fun deleteReply(replyId: Long, todoCardId: Long, argument: DeleteReplyArgument) {
        val foundTodoCard = todoRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard", todoCardId)
        val foundReply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)

        foundReply.checkAuthentication(argument.authorName, argument.password)

        replyRepository.deleteById(replyId)
    }
}