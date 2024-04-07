package org.example.api_signaling.controller

import org.example.api_signaling.properties.HostProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class WebAppController (private val hostProperties: HostProperties) {

    @GetMapping("/streamer")
    fun streamer(model: Model): String {
        model.addAttribute("host", hostProperties)
        return "streamer/main_view"
    }

    @GetMapping("/client")
    fun client(model: Model): String {
        model.addAttribute("host", hostProperties)
        return "client/main_view"
    }

    @GetMapping("/client/{roomId}")
    fun watchingPage(@PathVariable roomId: String, model: Model): String {
        model.addAttribute("host", hostProperties)
        model.addAttribute("roomId", roomId)
        return "client/watch_view";
    }
}
