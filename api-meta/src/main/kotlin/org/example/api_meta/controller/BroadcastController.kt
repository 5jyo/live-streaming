package org.example.api_meta.controller

import org.example.api_meta.dto.Broadcast
import org.example.api_meta.dto.BroadcastForm
import org.example.api_meta.service.BroadcastService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BroadcastController(
    private val broadcastService: BroadcastService
) {
    @GetMapping("/broadcasts")
    fun list(): List<Broadcast> {
        return broadcastService.getList()
    }

    @GetMapping("/broadcasts/{broadcast_id}")
    fun get(@PathVariable("broadcast_id") broadcastId: Long): ResponseEntity<Broadcast> {
        val broadcast = broadcastService.get(broadcastId)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(broadcast)
    }

    @PostMapping("/broadcasts")
    fun post(@RequestBody broadcastForm : BroadcastForm): ResponseEntity<Broadcast> {
        val broadcast = broadcastService.create(broadcastForm)
            ?: return ResponseEntity.badRequest().build()
        return ResponseEntity(broadcast, HttpStatus.CREATED)
    }

}