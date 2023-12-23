package com.razielo.todo.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Todo(
    @GeneratedValue(strategy = GenerationType.AUTO) @Id val id: Long = 0,
    val todo: String,
    val completed: Boolean = false,
    @Column(name = "created_at") val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at") val updatedAt: LocalDateTime = LocalDateTime.now()
)
