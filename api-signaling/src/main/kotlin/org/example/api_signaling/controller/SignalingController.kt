package org.example.api_signaling.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Slf4j
@Controller
class SignalingController {
    @MessageMapping("/{roomId}")
    @SendTo("/topic/{roomId}")
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
    @SendTo("/topic/{roomId}/{clientKey}/answer")
    fun answer(answer: String): String {
        return answer
    }

    @MessageMapping("/{roomId}/{clientKey}/ice/streamer")
    @SendTo("/topic/{roomId}/{clientKey}/ice/streamer")
    fun streamerIce(ice: String): String {
        return ice
    }

    @MessageMapping("/{roomId}/{clientKey}/ice/client")
    @SendTo("/topic/{roomId}/{clientKey}/ice/client")
    fun clientIce(ice: String): String {
        return ice
    }
}