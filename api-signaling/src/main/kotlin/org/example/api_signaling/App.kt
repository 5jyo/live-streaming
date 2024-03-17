package org.example.api_signaling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ApiSignalingApplication

fun main(args: Array<String>) {
    runApplication<ApiSignalingApplication>(*args)
}
