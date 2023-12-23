package com.razielo.todo.controller

import com.razielo.todo.entity.Todo
import com.razielo.todo.repository.TodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
class TodoController(private val todoRepository: TodoRepository) {
    @GetMapping("/todo/all")
    fun allTodos(): List<Todo> = todoRepository.findAll().toList()

    @GetMapping("/todo/{id}")
    fun todoById(@PathVariable id: Long): ResponseEntity<Any> {
        val todo = todoRepository.findById(id)
        if (todo.isEmpty) {
            ResponseEntity.status(404).body("Todo with id $id not found")
        }
        return ResponseEntity.ok(todo.get())
    }

    @PostMapping("/todo")
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> =
        todoRepository.save(todo).run { ResponseEntity.ok(this) }

    @PutMapping("/todo/{id}/toggle")
    fun completeTodo(@PathVariable id: Long): ResponseEntity<Any> {
        val existing = todoRepository.findById(id)
        if (existing.isEmpty) {
            return ResponseEntity.status(404).body("Todo with id $id not found")
        }
        val updated = existing.get().copy(completed = !existing.get().completed, updatedAt = LocalDateTime.now())
        todoRepository.save(updated)
        return ResponseEntity.ok(updated)
    }

    @PutMapping("/todo/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todo: Todo): ResponseEntity<Any> {
        val existing = todoRepository.findById(id)
        if (existing.isEmpty) {
            return ResponseEntity.status(404).body("Todo with id $id not found")
        }
        val updated = existing.get().copy(
            todo = todo.todo, completed = todo.completed, updatedAt = LocalDateTime.now()
        )
        todoRepository.save(updated)
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/todo/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Any> {
        val existing = todoRepository.findById(id)
        if (existing.isEmpty) {
            return ResponseEntity.status(404).body("Todo with id $id not found")
        }
        todoRepository.deleteById(id)
        return ResponseEntity.ok(existing.get())
    }
}
