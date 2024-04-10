package org.example.api_signaling.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix="host")
data class HostProperties(
    var meta: String = "",
    var docker: Docker? = null,
    var signaling: String = "",
)

// Host properties for docker
data class Docker(
    var meta: String? = null
)
