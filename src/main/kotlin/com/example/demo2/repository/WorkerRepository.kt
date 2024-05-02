package com.example.demo2.repository

import com.example.demo2.model.Worker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepository: JpaRepository<Worker, Long> {
    fun findById (id: Long?):Worker?
}