package com.project.todoapp.domain.todocard.service

import com.project.todoapp.domain.common.exception.ModelNotFoundException
import com.project.todoapp.domain.todocard.dtos.CreateTodoCardArguments
import com.project.todoapp.domain.todocard.dtos.TodoCardDto
import com.project.todoapp.domain.todocard.dtos.UpdateTodoCardArguments
import com.project.todoapp.domain.todocard.model.TodoCards
import com.project.todoapp.domain.todocard.repository.TodoCardRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoCardService (
    private val todoCardRepository: TodoCardRepository
){

    // DB로 데이터를 저장
    @Transactional
    fun createTodoCard(createTodoCardArguments: CreateTodoCardArguments): TodoCardDto {
        //DTO를 Entity 변환
        val todo = TodoCards(createTodoCardArguments.title,createTodoCardArguments.authorName,createTodoCardArguments.content)

        //Entity를 저장합니다!
        val todoCard = todoCardRepository.save(todo)

        return TodoCardDto.from(todoCard)
    }

    fun findById(todoCardId: Long): TodoCardDto? {
        //todoCardId로 db에서 todoCard 찾기
        val foundTodoCard = todoCardRepository.findByIdOrNull(todoCardId)

        return foundTodoCard?.let { TodoCardDto.from(it) }
    }

    fun findAll(): List<TodoCardDto> {
        val foundTodoCards = todoCardRepository.findAllByOrderByCreatedAtDesc()
        return foundTodoCards.map { TodoCardDto.from(it) }
    }

    @Transactional
    fun updateTodoCard(todoCardId: Long, updateTodoCardArguments: UpdateTodoCardArguments): TodoCardDto {
        // DB에서 todoCardId 를 통해 수정할 todoCard를 조회한다
        val foundTodoCard = todoCardRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard", todoCardId)
        // 값을 수정한다
        foundTodoCard.updateTodoCardField(updateTodoCardArguments)

        //todoCardRepository.save(foundTodoCard)

        return TodoCardDto.from(foundTodoCard)
    }

    fun deleteTodoCard(todoCardId: Long) {
        todoCardRepository.deleteById(todoCardId)
    }
}