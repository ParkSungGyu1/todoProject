package com.project.todoapp.domain

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

abstract class QueryDSLSupport {
    @PersistenceContext
    protected lateinit var entityManager: EntityManager

    protected val queryFactory : JPAQueryFactory
        get()  {
            return JPAQueryFactory(entityManager)
        }
}