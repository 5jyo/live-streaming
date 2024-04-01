package org.example.api_signaling.controller

import org.example.api_signaling.properties.HostProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController (private val hostProperties: HostProperties) {

    @GetMapping("/streamer")
    fun streamer(model: Model): String {
        model.addAttribute("host", hostProperties)
        return "streamer"
    }

    @GetMapping("/client")
    fun client(model: Model): String {
        model.addAttribute("host", hostProperties)
        return "client"
    }
}
