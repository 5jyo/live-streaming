package org.example.api_meta.controller

import org.example.api_meta.dto.Broadcast
import org.example.api_meta.dto.BroadcastForm
import org.example.api_meta.dto.BroadcastUpdateForm
import org.example.api_meta.service.BroadcastService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BroadcastController(
    private val broadcastService: BroadcastService
) {
    @GetMapping("/broadcasts")
    @CrossOrigin(origins = ["*"])
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

    @PutMapping("/broadcasts/{broadcast_id}")
    fun update(@PathVariable("broadcast_id") broadcastId: Long,
        @RequestBody broadcastUpdateForm : BroadcastUpdateForm): ResponseEntity<Broadcast> {
        val broadcast = broadcastService.update(broadcastId, broadcastUpdateForm)
            ?: return ResponseEntity.badRequest().build()
        return ResponseEntity(broadcast, HttpStatus.OK)
    }

}