package org.example.api_signaling.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Slf4j
@Controller
class SignalingController {
    val sessionIdToRoomId = ConcurrentHashMap<String, String>()
    val roomIdToUserSet = ConcurrentHashMap<String, Set<String>>()

    @ResponseBody
    @GetMapping("/room/{roomId}/count")
    fun getUserCount(@PathVariable roomId: String): Map<String, Any?> {
        val userCount = roomIdToUserSet[roomId]?.size

        val resBody = mutableMapOf<String, Any?>()
        resBody["userCount"] = userCount
        return resBody
    }

    @EventListener
    fun handleDisconnectEvent(event: SessionDisconnectEvent) {
        val roomId = sessionIdToRoomId[event.sessionId] ?: return
        roomIdToUserSet.compute(roomId) { _, userSet ->
            val updatedSet = userSet?.toMutableSet() ?: mutableSetOf()
            updatedSet.remove(event.sessionId)
            sessionIdToRoomId.remove(event.sessionId)
            updatedSet
        }
    }

    @MessageMapping("/{roomId}")
    @SendTo("/topic/{roomId}")
    @Throws(Exception::class)
    fun joinRoom(key: String, @DestinationVariable roomId: String, @Header simpSessionId: String, session: SimpMessageHeaderAccessor): String {
        sessionIdToRoomId[simpSessionId] = roomId
        roomIdToUserSet.compute(roomId) { _, userSet ->
            val updatedSet = userSet?.toMutableSet() ?: mutableSetOf()
            updatedSet.add(simpSessionId)
            updatedSet
        }
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