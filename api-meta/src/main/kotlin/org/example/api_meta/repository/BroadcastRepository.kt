package org.example.api_meta.repository

import org.example.api_meta.dto.Broadcast
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component


@Component
interface BroadcastRepository : JpaRepository<Broadcast, Long> {
}