package org.example.api_signaling.configuration

import org.example.api_signaling.client.MetaApiClient
import org.example.api_signaling.properties.HostProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class HttpClientConfig(private val hostProperties: HostProperties) {
    @Bean
    fun metaApiClient(builder: RestClient.Builder): MetaApiClient {
        // Set to docker domain if exists.
        // signaling docker container can't resolve localhost as meta api in bridge network
        val baseUrl = hostProperties.docker?.meta ?: hostProperties.meta
        val restClient = builder.baseUrl(baseUrl).build()
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build()
            .createClient(MetaApiClient::class.java)
    }
}