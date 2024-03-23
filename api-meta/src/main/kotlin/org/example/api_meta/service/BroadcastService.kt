package org.example.api_meta.service

import org.example.api_meta.dto.Broadcast
import org.example.api_meta.repository.BroadcastRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BroadcastService(
    private val broadcastRepository: BroadcastRepository
) {
    fun getList(): List<Broadcast> {
        return broadcastRepository.findAll()
    }

    fun get(broadcastId: Long): Broadcast? {
        return broadcastRepository.findByIdOrNull(broadcastId)
    }
}