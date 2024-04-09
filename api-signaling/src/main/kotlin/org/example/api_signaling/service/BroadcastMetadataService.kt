package org.example.api_signaling.service

import org.example.api_signaling.client.MetaApiClient
import org.example.api_signaling.dto.BroadcastUpdateForm
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class BroadcastMetadataService(private val client: MetaApiClient) {

    @Async
    fun updateViewerCount(roomId: String, viewerCount: Long?) {
        if (viewerCount == null) {
            return
        }
        val broadcastUpdateForm = BroadcastUpdateForm(viewer_count = viewerCount)
        client.updateBroadcast(roomId, broadcastUpdateForm)
    }

    @Async
    fun updateBroadcastStatus(status: String) {
        throw NotImplementedError()
    }
}