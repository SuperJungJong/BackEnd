package org.sherlockhomes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class SherlockHomesApplication

fun main(args: Array<String>) {
    runApplication<SherlockHomesApplication>(*args)
}
