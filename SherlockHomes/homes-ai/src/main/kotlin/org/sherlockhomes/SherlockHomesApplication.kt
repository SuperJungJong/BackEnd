package org.sherlockhomes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@PropertySources(
    PropertySource("classpath:gpt_env.yml"),
)
class SherlockHomesApplication

fun main(args: Array<String>) {
    runApplication<SherlockHomesApplication>(*args)
}
