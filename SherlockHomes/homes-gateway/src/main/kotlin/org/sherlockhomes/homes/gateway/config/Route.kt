package org.sherlockhomes.homes.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Route {

    @Bean
    fun cRoute(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes() // 필터 X
            //USERß
            .route(
                "login"
            ) { r: PredicateSpec ->
                r.path("/login/**")
                    .uri("lb://USER")
            }
            .route(
                "user"
            ) { r: PredicateSpec ->
                r.path("/users/login/**")
                    .uri("lb://USER")
            }
            .route(
                "dev"
            ) { r: PredicateSpec ->
                r.path("/dev/**")
                    .uri("lb://USER")
            }
            .route(
                "refreshToken"
            ) { r: PredicateSpec ->
                r.path("/token/**")
                    .uri("lb://USER")
            } //CALENDARROLEMANAGER

            .route(
                "userRole"
            ) { r: PredicateSpec ->
                r.path("/calendar-user/**")
                    .uri("lb://CALENDARROLEMANAGER")
            } // jwt 필터

            .build()
    }
}