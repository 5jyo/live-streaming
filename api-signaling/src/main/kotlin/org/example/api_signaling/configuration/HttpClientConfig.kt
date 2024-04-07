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
        val restClient = builder.baseUrl(hostProperties.meta).build()
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build()
            .createClient(MetaApiClient::class.java)
    }
}