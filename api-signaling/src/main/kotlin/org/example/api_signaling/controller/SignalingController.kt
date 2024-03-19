package org.example.api_signaling.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Slf4j
@Controller
class SignalingController {
    @MessageMapping("/{roomId}/join_room")
    @SendTo("/topic/{roomId}/welcome")
    @Throws(Exception::class)
    fun joinRoom(key: String): String {
        return key
    }

    @MessageMapping("/{roomId}/{clientKey}/offer")
    @SendTo("/topic/{roomId}/{clientKey}/offer")
    fun offer(offer: String): String {
        return offer
    }

    @MessageMapping("/{roomId}/{clientKey}/answer")
    @SendTo("/topic/{roomId}{clientKey}/answer")
    fun answer(answer: String): String {
        return answer
    }

    @MessageMapping("/{roomId}/{clientKey}/ice")
    @SendTo("/topic/{roomId}/{clientKey}/ice")
    fun ice(ice: String): String {
        return ice
    }
}