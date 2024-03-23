package org.example.api_meta.controller

import org.example.api_meta.dto.Broadcast
import org.example.api_meta.service.BroadcastService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BroadcastController(
        private val broadcastService: BroadcastService
) {
    @GetMapping("/broadcasts")
    fun list(): List<Broadcast> {
        return broadcastService.getList()
    }

}