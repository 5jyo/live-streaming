package org.example.api_meta.dto

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Entity
class Broadcast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "broadcast_id", nullable = false)
    open var id: Long? = null

    @Column(name = "name")
    open var name: String? = null

    @Column(name = "description")
    open var description: String? = null

    @Column(name = "started_at")
    open var started_at: LocalDateTime? = null

    @Column(name = "ended_at")
    open var ended_at: OffsetDateTime? = null

    @Column(name = "created_at")
    open var created_at: LocalDateTime? = null

    @Column(name = "modified_at")
    open var modified_at: LocalDateTime? = null

    @Column(name = "status", length = 50)
    open var status: String? = null

    @Column(name = "viewer_count")
    open var viewer_count: Long? = null
}
