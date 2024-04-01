package org.example.api_signaling.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix="host")
data class HostProperties(
    var meta: String = "",
    var signaling: String = "",
)