package com.razielo.todo.controller

import com.razielo.todo.entity.Todo
import com.razielo.todo.repository.TodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
@CrossOrigin(
    origins = ["*"],
    methods = [RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT]
)
class TodoController(private val todoRepository: TodoRepository) {

    @GetMapping("/todo/all")
    fun allTodos(): List<Todo> {
        val notCompleted = todoRepository.findAllNotCompletedOrderByCreatedAt()
        val completed = todoRepository.findAllCompletedOrderByUpdatedAt()
        return notCompleted + completed
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
