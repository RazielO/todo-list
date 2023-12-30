package com.razielo.todo.repository

import com.razielo.todo.entity.Todo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo, Long> {
    @Query("SELECT t FROM Todo t WHERE t.completed = false ORDER BY t.createdAt")
    fun findAllNotCompletedOrderByCreatedAt(): List<Todo>

    @Query("SELECT t FROM Todo t WHERE t.completed = true ORDER BY t.updatedAt DESC")
    fun findAllCompletedOrderByUpdatedAt(): List<Todo>
}
