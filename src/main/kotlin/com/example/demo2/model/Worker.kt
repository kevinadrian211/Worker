package com.example.demo2.model

import com.fasterxml.jackson.databind.node.DecimalNode
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "worker")
class Worker(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null,

    @Column(name = "worker_name")
    var workerName: String? = null,

    var position: String? = null,
    var age: Int? = null,
    var salary: BigDecimal? = null
)
