package com.example.demo2.service

import com.example.demo2.model.Worker
import com.example.demo2.repository.WorkerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class WorkerService {

    @Autowired
    lateinit var workerRepository: WorkerRepository

    fun list(): List<Worker> {
        return workerRepository.findAll()
    }

    fun save(worker: Worker): Worker {
        return workerRepository.save(worker)
    }

    fun update(worker: Worker): Worker {
        try {
            workerRepository.findById(worker.id)
                ?: throw Exception("Id Existe")
            return workerRepository.save(worker)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(worker: Worker): Worker {
        try {
            val response = workerRepository.findById(worker.id)
                ?: throw Exception("Id Existe")
            response.apply {
                workerName = worker.workerName
            }
            return workerRepository.save(worker)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            val workerOptional = workerRepository.findById(id)
            if (workerOptional.isPresent) {
                val worker = workerOptional.get()
                workerRepository.delete(worker)
            } else {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró ningún trabajador con el ID proporcionado")
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el trabajador", ex)
        }
    }

}
