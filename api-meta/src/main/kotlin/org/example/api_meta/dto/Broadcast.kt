package org.example.api_meta.dto

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Entity
class Broadcast(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "broadcast_id", nullable = false)
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "started_at")
    var started_at: LocalDateTime? = null,

    @Column(name = "ended_at")
    var ended_at: OffsetDateTime? = null,

    @Column(name = "created_at")
    var created_at: LocalDateTime = LocalDateTime.now(),

    @Column(name = "modified_at")
    var modified_at: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    var status: BroadcastStatus = BroadcastStatus.READY,

    @Column(name = "viewer_count")
    var viewer_count: Long = 0,
)
