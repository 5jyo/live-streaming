package org.example.api_meta.service

import org.example.api_meta.dto.Broadcast
import org.example.api_meta.dto.BroadcastForm
import org.example.api_meta.dto.BroadcastStatus
import org.example.api_meta.dto.BroadcastUpdateForm
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

    fun create(broadcastForm: BroadcastForm): Broadcast? {
        val broadcast = Broadcast(
            name = broadcastForm.name,
            description = broadcastForm.description,
            status = BroadcastStatus.STREAMING
        )
        return broadcastRepository.save(broadcast)
    }

    fun update(broadcastId: Long, broadcastUpdateForm: BroadcastUpdateForm): Broadcast? {
        return broadcastRepository.findById(broadcastId)
            .map { broadcast ->
                if (broadcastUpdateForm.name != null) {
                    broadcast.name = broadcastUpdateForm.name
                }
                if (broadcastUpdateForm.description != null) {
                    broadcast.description = broadcastUpdateForm.description
                }
                if (broadcastUpdateForm.modified_at != null) {
                    broadcast.modified_at = broadcastUpdateForm.modified_at
                }
                if (broadcastUpdateForm.viewer_count != null) {
                    broadcast.viewer_count = broadcastUpdateForm.viewer_count
                }
                if (broadcastUpdateForm.started_at != null) {
                    broadcast.started_at = broadcastUpdateForm.started_at
                }
                if (broadcastUpdateForm.ended_at != null) {
                    broadcast.ended_at = broadcastUpdateForm.ended_at
                }
                if (broadcastUpdateForm.status != null) {
                    broadcast.status = broadcastUpdateForm.status
                }
                if (broadcastUpdateForm.created_at != null) {
                    broadcast.created_at = broadcastUpdateForm.created_at
                }
                broadcastRepository.save(broadcast)
            }
            .orElse(null)
    }
}


