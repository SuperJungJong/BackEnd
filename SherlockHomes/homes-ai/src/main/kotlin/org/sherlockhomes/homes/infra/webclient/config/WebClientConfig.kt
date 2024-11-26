package org.sherlockhomes.homes.infra.webclient.config

import io.netty.channel.ChannelOption
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.util.InsecureTrustManagerFactory
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient

@Configuration
class WebClientConfig {

    @Bean
    fun webClient(): WebClient =
        WebClient.builder()
            .clientConnector(
                ReactorClientHttpConnector(
                    createHttpClient()
                )
            ).build()

    fun createHttpClient(): HttpClient =
        HttpClient.create()
            .secure {
                it.sslContext(
                    SslContextBuilder.forClient()
                        .trustManager(InsecureTrustManagerFactory.INSTANCE)
                        .build()
                )
            }
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
            .doOnConnected { conn: Connection ->
                conn
                    .addHandlerLast(ReadTimeoutHandler(3))
                    .addHandlerLast(WriteTimeoutHandler(3))
            }
}