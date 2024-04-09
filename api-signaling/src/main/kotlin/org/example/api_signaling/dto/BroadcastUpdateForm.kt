package org.example.api_signaling.dto

import java.time.LocalDateTime
import java.time.OffsetDateTime

data class BroadcastUpdateForm (
    val name: String? = null,
    val description: String? = null,
    val started_at: LocalDateTime? = null,
    val ended_at: OffsetDateTime? = null,
    val created_at: LocalDateTime? = null,
    val modified_at: LocalDateTime = LocalDateTime.now(),
    val status: BroadcastStatus? = null,
    val viewer_count: Long? = null,
)

enum class BroadcastStatus {
    READY, STREAMING, CLOSED
}
