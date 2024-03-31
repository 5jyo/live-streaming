package org.example.api_signaling

import org.example.api_signaling.properties.HostProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(HostProperties::class)
class ApiSignalingApplication

fun main(args: Array<String>) {
    runApplication<ApiSignalingApplication>(*args)
}
