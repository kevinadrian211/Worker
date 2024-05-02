package com.example.demo2.controller

import com.example.demo2.model.Worker
import com.example.demo2.service.WorkerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/worker")
class WorkerController {

    @Autowired
    lateinit var workerService: WorkerService

    @GetMapping
    fun list(): List<Worker> {
        return workerService.list()
    }

    @PostMapping
    fun save(@RequestBody worker: Worker): Worker {
        return workerService.save(worker)
    }

    @PutMapping
    fun update(@RequestBody worker: Worker): ResponseEntity<Worker> {
        return ResponseEntity(workerService.update(worker), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody worker: Worker): ResponseEntity<Worker> {
        return ResponseEntity(workerService.updateName(worker), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        workerService.delete(id)
        return ResponseEntity.ok("Worker eliminado exitosamente")
    }
}
