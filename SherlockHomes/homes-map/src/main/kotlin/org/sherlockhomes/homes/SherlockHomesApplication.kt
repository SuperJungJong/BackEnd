package org.sherlockhomes.homes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
class SherlockHomesApplication

fun main(args: Array<String>) {
    runApplication<SherlockHomesApplication>(*args)
}

