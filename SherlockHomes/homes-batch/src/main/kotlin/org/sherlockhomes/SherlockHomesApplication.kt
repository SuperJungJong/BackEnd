package org.sherlockhomes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@PropertySources(
    PropertySource("classpath:env.yml"),
    PropertySource("classpath:ApiEndPoint.yml"),
    PropertySource("classpath:DataApiEnv.yml"),
)
class SherlockHomesApplication

fun main(args: Array<String>) {

    runApplication<SherlockHomesApplication>(*args)
}
