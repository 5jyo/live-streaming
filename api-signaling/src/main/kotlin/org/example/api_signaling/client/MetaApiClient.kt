package org.example.api_signaling.client

import org.example.api_signaling.dto.BroadcastUpdateForm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PutExchange

@HttpExchange("/broadcasts")
interface MetaApiClient {
    @PutExchange("/{broadcast_id}")
    fun updateBroadcast(@PathVariable("broadcast_id") broadcastId: String, @RequestBody broadcastUpdateForm: BroadcastUpdateForm)
}