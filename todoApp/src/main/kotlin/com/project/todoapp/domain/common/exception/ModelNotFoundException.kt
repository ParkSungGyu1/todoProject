package com.project.todoapp.domain.common.exception

data class ModelNotFoundException(val modelName: String, val id: Long?):
    RuntimeException("Model $modelName not found with given id: $id")
