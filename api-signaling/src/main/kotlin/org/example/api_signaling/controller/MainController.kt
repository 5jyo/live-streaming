package org.example.api_signaling.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/streamer")
    fun streamer(): String {
        return "streamer"
    }

    @GetMapping("/client")
    fun client(): String {
        return "client"
    }
}
